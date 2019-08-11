package com.kd.serwisAukcyjny.auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface AuctionRepository  {
//    <T extends Auction> extends JpaRepository<Auction, Long>, QuerydslPredicateExecutor<Auction>
//Optional<T> findAuctionById(Long id);
//
//@Query("select a from Auction a where upper(a.title) like concat('%',upper(?1),'%')")
//List<T> findAuctionByTitle(String searchText);

}
