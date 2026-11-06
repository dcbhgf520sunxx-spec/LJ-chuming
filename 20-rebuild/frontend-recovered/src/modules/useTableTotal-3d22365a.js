import { b as m, e7 as d, iX as A, iY as N } from "../shared/runtime.js";
import { ref as u } from "vue";
import { reactive as T } from "vue";
function w(p = false, { defineData: h = [] } = {}) {
  const l = u([]), c = u(0), g = (n) => {
    try {
      if (!n || !n.columns || !n.data || n.data.length === 0) return [];
      const { columns: e, data: i } = n;
      if (m(e) || m(i)) return;
      const r = new Array(e.length).fill(null);
      if (e.forEach((t, o) => {
        if (o === 0) {
          r[o] = "合计";
          return;
        }
        if (h.includes(t.property)) {
          let s = 0;
          i.forEach((f) => {
            if (f[t.property]) {
              const a = d(f[t.property]);
              typeof a == "number" && !isNaN(a) && (s = A(s + a, 2));
            }
          }), r[o] = s;
        }
      }), p && r.length === e.length) {
        const t = r[r.length - 1];
        c.value = t !== null ? Number(t) : 0;
      }
      return l.value = r, N(r);
    } catch (e) {
      return console.error("An error occurred while calculating summaries:", e), [];
    }
  }, y = T({ pageSize: 20, pageNumber: 1 }), b = u(0);
  return { applyAmount: c, requestData: y, total: b, _sums: l, getSummaries: g };
}
export {
  w as u
};
