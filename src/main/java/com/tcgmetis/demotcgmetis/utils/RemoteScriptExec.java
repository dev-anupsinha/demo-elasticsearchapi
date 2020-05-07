package com.tcgmetis.demotcgmetis.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;    

public class RemoteScriptExec {

    public static void main(String[] args) {

        JSch jsch = new JSch();
        StringBuilder outputBuffer = new StringBuilder();       

        Session session;
        try {

            // Open a Session to remote SSH server and Connect.
            // Set User and IP of the remote host and SSH port.
            session = jsch.getSession("anup", "192.168.43.56", 22);
            // When we do SSH to a remote host for the 1st time or if key at the remote host 
            // changes, we will be prompted to confirm the authenticity of remote host. 
            // This check feature is controlled by StrictHostKeyChecking ssh parameter. 
            // By default StrictHostKeyChecking  is set to yes as a security measure.
            session.setConfig("StrictHostKeyChecking", "no");
            //Set password
            session.setPassword("P@ssw0rd!");
            session.connect();

            
            // create the execution channel over the session          
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            // Set the command to execute on the channel and execute the command
            channelExec.setCommand("service --status-all | grep docker"); //sh myscript.sh 
            
            
            
            InputStream commandOutput = channelExec.getInputStream();
            channelExec.connect();
            int readByte = commandOutput.read();

            while(readByte != 0xffffffff)
            {
               outputBuffer.append((char)readByte);
               readByte = commandOutput.read();
            }
            System.out.println("bb:"+ outputBuffer);           

            // Command execution completed here.
            

            // Retrieve the exit status of the executed command
            int exitStatus = channelExec.getExitStatus();
            System.out.println("exitStatus"+exitStatus);
            if (exitStatus > 0) {
                System.out.println("Remote script exec error! " + exitStatus);
            }
            //Disconnect the Session
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			outputBuffer=null;			
		}

    }
}

