package com.kn.product.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ResultCheckStyle;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;

@Entity
@SQLDelete(sql = "UPDATE product set record_status='DELETED' where en=?", check = ResultCheckStyle.COUNT)
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_Product", allocationSize = 1)
	@Column(name = "EN", nullable = false)
	private Long en;

	@Column(name = "PRODUCT_ID")
	private Long productId;
	
		@Column(name = "PRODUCT_NAME")
	    private String productName;

		@Column(name = "PRODUCT_UOM_ID")
		private Long productUomId;
		
		@Column(name = "PRODUCT_UOM")
	    private String productUom;
				
		@Column(name = "PRODUCT_DES")
	    private String productDes;
		
        @Column(name = "RECORD_STATUS")
	    private String recordStatus;

		/**
		 * @return the en
		 */
		public Long getEn() {
			return en;
		}

		/**
		 * @param en the en to set
		 */
		public void setEn(Long en) {
			this.en = en;
		}

		/**
		 * @return the productId
		 */
		public Long getProductId() {
			return productId;
		}

		/**
		 * @param productId the productId to set
		 */
		public void setProductId(Long productId) {
			this.productId = productId;
		}

		/**
		 * @return the productName
		 */
		public String getProductName() {
			return productName;
		}

		/**
		 * @param productName the productName to set
		 */
		public void setProductName(String productName) {
			this.productName = productName;
		}

		/**
		 * @return the productUomId
		 */
		public Long getProductUomId() {
			return productUomId;
		}

		/**
		 * @param productUomId the productUomId to set
		 */
		public void setProductUomId(Long productUomId) {
			this.productUomId = productUomId;
		}

		/**
		 * @return the productUom
		 */
		public String getProductUom() {
			return productUom;
		}

		/**
		 * @param productUom the productUom to set
		 */
		public void setProductUom(String productUom) {
			this.productUom = productUom;
		}

		/**
		 * @return the productDes
		 */
		public String getProductDes() {
			return productDes;
		}

		/**
		 * @param productDes the productDes to set
		 */
		public void setProductDes(String productDes) {
			this.productDes = productDes;
		}

		/**
		 * @return the recordStatus
		 */
		public String getRecordStatus() {
			return recordStatus;
		}

		/**
		 * @param recordStatus the recordStatus to set
		 */
		public void setRecordStatus(String recordStatus) {
			this.recordStatus = recordStatus;
		}

			
}