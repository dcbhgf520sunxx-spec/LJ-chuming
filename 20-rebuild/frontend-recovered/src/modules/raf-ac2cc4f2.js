const o = { intervalTimer: null, timeoutTimer: null, setTimeout(m, r) {
  const t = Date.now, e = t();
  let i = e;
  const n = () => {
    this.timeoutTimer = requestAnimationFrame(n), i = t(), i - e >= r && (m(), cancelAnimationFrame(this.timeoutTimer));
  };
  return this.timeoutTimer = requestAnimationFrame(n), this.timeoutTimer;
}, clearTimeout() {
  cancelAnimationFrame(this.timeoutTimer);
}, setInterval(m, r) {
  const t = Date.now;
  let e = t(), i = e;
  const n = () => {
    this.intervalTimer = requestAnimationFrame(n), i = t(), i - e >= r && (e = t(), i = e, m());
  };
  return this.intervalTimer = requestAnimationFrame(n), this.intervalTimer;
}, clearInterval() {
  cancelAnimationFrame(this.intervalTimer);
} };
export {
  o as R
};
