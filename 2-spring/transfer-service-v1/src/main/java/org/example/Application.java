package org.example;

import org.example.repository.AccountRepository;
import org.example.repository.JdbcAccountRepository;
import org.example.repository.JpaAccountRepository;
import org.example.service.TransferService;
import org.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");

    public static void main(String[] args) {

        //----------------------------------------------------------
        // init / boot phase
        //----------------------------------------------------------
        logger.info("-".repeat(50));
        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
        AccountRepository jpaAccountRepository = new JpaAccountRepository();
        TransferService transferService = new UPITransferService(jdbcAccountRepository); // DI
        logger.info("-".repeat(50));
        //----------------------------------------------------------
        // use phase
        //----------------------------------------------------------


        transferService.transfer(100.00, "1", "2");
        logger.info("--");
        transferService.transfer(100.00, "1", "2");


        logger.info("-".repeat(50));
        //----------------------------------------------------------
        // destroy phase
        //----------------------------------------------------------

        logger.info("-".repeat(50));
        //----------------------------------------------------------

    }
}
