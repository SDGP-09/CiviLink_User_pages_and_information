package com.example.demo.entities;
import jakarta.persistence.*;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("consultant")
public class Consultant extends User {
        private String specialization;
        private String qualifications;
        private String services;
        private double minProjectValue;
        private double professionalFee;
        private double platformFee;

        public Consultant() {
        }

        public Consultant(String specialization, String qualifications, String services, double minProjectValue, double professionalFee, double platformFee) {
                this.specialization = specialization;
                this.qualifications = qualifications;
                this.services = services;
                this.minProjectValue = minProjectValue;
                this.professionalFee = professionalFee;
                this.platformFee = platformFee;
        }

        public String getSpecialization() {
                return specialization;
        }

        public String getQualifications() {
                return qualifications;
        }

        public String getServices() {
                return services;
        }

        public double getMinProjectValue() {
                return minProjectValue;
        }

        public double getProfessionalFee() {
                return professionalFee;
        }

        public double getPlatformFee() {
                return platformFee;
        }

        public void setSpecialization(String specialization) {
                this.specialization = specialization;
        }

        public void setQualifications(String qualifications) {
                this.qualifications = qualifications;
        }

        public void setServices(String services) {
                this.services = services;
        }

        public void setMinProjectValue(double minProjectValue) {
                this.minProjectValue = minProjectValue;
        }

        public void setProfessionalFee(double professionalFee) {
                this.professionalFee = professionalFee;
        }

        public void setPlatformFee(double platformFee) {
                this.platformFee = platformFee;
        }

}

