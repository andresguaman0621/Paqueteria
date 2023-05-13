import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TrackingSystem {
    private List<Package> packages;

    public TrackingSystem() {
        packages = new ArrayList<>();
    }


    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public void addPackage(Package pkg) {
        packages.add(pkg);
    }

    public boolean removePackage(String trackingNumber) {
        for (int i = 0; i < packages.size(); i++) {
            if (packages.get(i).getTrackingNumber().equals(trackingNumber)) {
                packages.remove(i);
                return true;
            }
        }
        return false;
}

    public Package searchByRecipientAddress(String recipientAddress) {
        for (Package pkg : packages) {
            if (pkg.getRecipientAddress().getCity().equals(recipientAddress)) {
                return pkg;
            }
        }
        return null;
    }
    public Package searchByTrackingNumber(String trackingNumber) {
        sortPackagesByTrackingNumber();
        int left = 0;
        int right = packages.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Package currentPackage = packages.get(mid);

            if (currentPackage.getTrackingNumber().equals(trackingNumber)) {
                return currentPackage;
            }

            if (currentPackage.getTrackingNumber().compareTo(trackingNumber) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    private void sortPackagesByTrackingNumber() {
        Collections.sort(packages, (pkg1, pkg2) ->
                pkg1.getTrackingNumber().compareTo(pkg2.getTrackingNumber()));
    }
}
