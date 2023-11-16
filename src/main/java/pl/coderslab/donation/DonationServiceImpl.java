package pl.coderslab.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService{
    private final DonationRepository donationRepository;

    @Override
    public Long countAllDonations() {
        return donationRepository.count();
    }

    @Override
    public Integer countAllQuantity() {
        List<Donation> donations = donationRepository.findAll();
        Integer count = 0;
        for (Donation d: donations) {
            count += d.getQuantity();
        }
        return count;
    }
}
