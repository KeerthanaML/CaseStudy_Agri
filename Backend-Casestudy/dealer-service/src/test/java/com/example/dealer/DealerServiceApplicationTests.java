package com.example.dealer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.dealer.Controller.DealerController;
import com.example.dealer.model.Dealer;
import com.example.dealer.service.DealerService;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DealerControllerTest {

    @InjectMocks
    private DealerController dealerController;

    @Mock
    private DealerService dealerService;

    @Test
    public void testGetAllDealers() {
        List<Dealer> dealers = Arrays.asList(
            new Dealer("1", "John", "john@example.com", "password1"),
            new Dealer("2", "Alice", "alice@example.com", "password2")
        );

        when(dealerService.getAllDealers()).thenReturn(dealers);

        List<Dealer> result = dealerController.getAllDealers();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetDealerById() {
        Dealer sampleDealer = new Dealer("1", "John", "john@example.com", "password1");
        when(dealerService.getDealerById("1")).thenReturn(sampleDealer);

        Dealer result = dealerController.getDealerById("1");

        assertNotNull(result);
        assertEquals(sampleDealer.getId(), result.getId());
    }

    @Test
    public void testCreateDealer() {
        Dealer newDealer = new Dealer("3", "Ramya", "ramya@example.com", "password3");
        when(dealerService.createDealer(newDealer)).thenReturn(newDealer);

        Dealer createdDealer = dealerController.createDealer(newDealer);

        assertNotNull(createdDealer);
        assertEquals(newDealer.getId(), createdDealer.getId());
    }

    @Test
    public void testUpdateDealer() {
        Dealer updatedDealer = new Dealer("1", "John", "john@example.com", "updatedPassword");
        when(dealerService.updateDealer(updatedDealer)).thenReturn(updatedDealer);

        Dealer result = dealerController.updateDealer("1", updatedDealer);

        assertNotNull(result);
        assertEquals(updatedDealer.getPassword(), result.getPassword());
    }

}


