import org.jnetpcap.*;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.format.FormatUtils;

public class PacketCapture {
    public static void main(String[] args) {
        StringBuilder errbuf = new StringBuilder();
        Pcap pcap = Pcap.openLive("eth0", 65536, Pcap.MODE_PROMISCUOUS, 10_000, errbuf);
        
        if (pcap == null) {
            System.err.println("Error while opening device: " + errbuf);
            return;
        }
        
        PcapPacketHandler<String> handler = (packet, user) -> {
            System.out.println("Packet captured from: " + FormatUtils.ip(packet.getCaptureHeader().caplen()));
        };
        
        pcap.loop(10, handler, "Capture");
        pcap.close();
    }
}
