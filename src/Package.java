import java.time.LocalDate;
public class Package {
    private static int nextTrackingNumber = 1;

    private String trackingNumber;
    private Address senderAddress;
    private Address recipientAddress;
    private LocalDate estimatedDeliveryDate;

    public Package(Address senderAddress, Address recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber = generateTrackingNumber();
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private String generateTrackingNumber() {
        String formattedNumber = String.format("%03d", nextTrackingNumber);
        nextTrackingNumber++;
        return "AS" + formattedNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(Address recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @Override
    public String toString() {
        return
                "\ntrackingNumber: '" + trackingNumber +
                "\nsenderAddress: " + senderAddress +
                "\nrecipientAddress: " + recipientAddress +
                "\nestimatedDeliveryDate: " + estimatedDeliveryDate +
                "\n\n\n";
    }
}
