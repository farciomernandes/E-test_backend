package com.example.etest.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Perfil implements GrantedAuthority {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String profileName;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getPerfilName() {
            return profileName;
        }
        public void setPerfilName(String profileName) {
            this.profileName = profileName;
        }

        @Override
        public String getAuthority() {
            return profileName;
        }
    }

