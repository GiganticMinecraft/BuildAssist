# BuildAssist

## 前提プラグイン
- [spigot-1.12.2](https://cdn.getbukkit.org/spigot/spigot-1.12.2.jar)
- [SeichiAssist](https://github.com/GiganticMinecraft/SeichiAssist)

## ビルド
前提プラグインのjarを`${プロジェクトディレクトリ}/localDependencies`にコピーしてください。

Mavenがコマンドラインで使える状態で`mvn install`を実行すると、`target`フォルダにjarが出力されます。

Eclipseを開発に使用している場合、プロジェクトをmavenプロジェクトとして読み込み、
実行(R) -> 実行(S) -> Maven Clean を実行
そのあと、実行(R) -> 実行(S) -> Maven Install を実行
すれば`target`フォルダにjarが出力されます。

IntelliJ IDEAを開発に使用している場合、プロジェクトをmavenプロジェクトとして読み込み、
MavenタブからLifecycle -> installを実行すれば`target`フォルダにjarが出力されます。

## 利用条件
- GPLv3ライセンスでの公開です。ソースコードの使用規約等はGPLv3ライセンスに従います。
- 当リポジトリのコードの著作権はunchamaが所有しています。
- 独自機能の追加やバグの修正等、当サーバーの発展への寄与を目的としたコードの修正・改変を歓迎しています。その場合、ギガンティック☆整地鯖(以下、当サーバー)のDiscordコミュニティに参加して、当コードに関する詳細なサポートを受けることが出来ます。
