from __future__ import print_function
from time import time

from sklearn.feature_extraction.text import TfidfVectorizer, CountVectorizer
from sklearn.decomposition import NMF, LatentDirichletAllocation
from sklearn.datasets import fetch_20newsgroups
import main
import numpy as np
import lda
n_samples = 2000
n_features = 1000
n_topics = 10
n_top_words = 10


t0 = time()
data_samples = main.fetch()

print("done in %0.3fs." % (time() - t0))
# Use tf-idf features for NMF.
print("Extracting tf-idf features for NMF...")
tfidf_vectorizer = TfidfVectorizer(max_df=0.95, min_df=2, #max_features=n_features,
                                   stop_words='english')
t0 = time()
tfidf = tfidf_vectorizer.fit_transform(data_samples)
print("done in %0.3fs." % (time() - t0))

# Use tf (raw term count) features for LDA.
print("Extracting tf features for LDA...")
tf_vectorizer = CountVectorizer(max_df=0.95, min_df=2, max_features=n_features,
                                stop_words='english')
#t0 = time()
tf = tf_vectorizer.fit_transform(data_samples)
new_model = lda.LDA(n_topics=20, n_iter=30, random_state=1)
new_model.fit(tf)

doc_topic = new_model.doc_topic_

for i in range(10):
    print("{} (top topic: {})".format(data_samples[i].split()[-2], doc_topic[i].argmax()))

topic_word = new_model.topic_word_
vocab = main.get_vocab()
for i, topic_dist in enumerate(topic_word):
    topic_words = np.array(vocab)[np.argsort(topic_dist)][:-n_top_words:-1]
    print('Topic {}: {}'.format(i, ' '.join(topic_words)))
