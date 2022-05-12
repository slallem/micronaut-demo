package fr.systapps;

import io.micronaut.core.util.StringUtils;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

@MicronautTest
class FtpTest {

    @Test
    void ftpReadTest() {

        // Find publicly available FTP sites for testing at https://www.mmnt.net/
        // Here using ftp://ftp.u-paris10.fr for simple text-file read test
        String ftp_server = "ftp.u-paris10.fr";
        int ftp_port = 21;
        String ftp_user = "anonymous";
        String ftp_password = "guest";
        String remoteFilePath = "/welcome.msg";

        Assertions.assertTrue(StringUtils.isNotEmpty(
                ftpRead(ftp_server, ftp_port, ftp_user, ftp_password, remoteFilePath)
        ));
    }

    String ftpRead(String ftp_server, int ftp_port, String ftp_user, String ftp_password, String remoteFilePath) {

        System.out.println("Starting FTP Read test >>>");

        StringBuffer sb = new StringBuffer();

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftp_server, ftp_port);
            ftpClient.login(ftp_user, ftp_password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            InputStream inputStream = ftpClient.retrieveFileStream(remoteFilePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while(reader.ready()) {
                String line = reader.readLine();
                sb.append(line);
                System.out.println(line);
            }
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("<<< End of FTP read test.");


        return sb.toString();

    }


}
