package com.rca.stock.models;
import jakarta.persistence.*;
   @Entity
   public class Reviews {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String content;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id")
        private Product product;

        public Reviews(){
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Reviews(String content, Product product, User user){
            this.content = content;
            this.product = product;
            this.user = user;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }


