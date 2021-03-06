package org.shop;

import org.shop.api.impl.UserServiceImpl;
import org.shop.repository.factory.UserRepositoryFactory;

/**
 * The main Data Initializer util class.
 */
public class DataInitializer {

    /** The seller initializer. */
    private SellerInitializer sellerInitializer;
    
    /** The product initializer. */
    private ProductInitializer productInitializer;
    
    /** The proposal initializer. */
    private ProposalInitializer proposalInitializer;
    
    /** The user initializer. */
    private UserInitializer userInitializer;

    
    public void setSellerInitializer(SellerInitializer sellerInitializer) {
        this.sellerInitializer = sellerInitializer;
    }


    public void setProductInitializer(ProductInitializer productInitializer) {
        this.productInitializer = productInitializer;
    }


    public void setProposalInitializer(ProposalInitializer proposalInitializer) {
        this.proposalInitializer = proposalInitializer;
    }


    public void setUserInitializer(UserInitializer userInitializer) {
        this.userInitializer = userInitializer;
    }

    /**
     * Inits the data.
     */
    public void initData() {
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }

    public void initMethod() {
      UserServiceImpl userService = new UserServiceImpl();
      userService.populate( new UserRepositoryFactory().createUserRepository() );
      userInitializer = new UserInitializer( userService );
    }
}
