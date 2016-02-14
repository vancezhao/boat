package com.vance.boat.mongodb.service;

import com.vance.boat.api.TorrentDomain;
import com.vance.boat.api.TorrentService;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.springframework.stereotype.Component;

/**
 * Created by vancezhao on 16/2/14.
 */

@Component
public class TorrentServiceHandler implements TorrentService.Iface {

  @Override public TorrentDomain findTorrent(int id) throws TException {
    return null;
  }

  @Override public void saveTorrent(TorrentDomain torrent) throws TException {

  }
}
