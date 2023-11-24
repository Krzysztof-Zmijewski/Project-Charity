package pl.coderslab.donation;

public interface DonationService {
    public Integer countAllQuantity ();
    public Long countAllDonations();
    public void create(Donation donation);
}
