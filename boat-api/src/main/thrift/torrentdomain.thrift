namespace java com.vance.boat.api

struct TorrentDomain {
  5: string torrentName;
  6: string torrentPath;
  7: list<string> imageNames;
}

service TorrentService {
    TorrentDomain findTorrent(4: i32 id);
    void saveTorrent(8: TorrentDomain torrent);
}