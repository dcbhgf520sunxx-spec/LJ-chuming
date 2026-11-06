import { ref as o } from "vue";
import * as $ from "lodash";
import { onMounted as v } from "vue";
import { onUnmounted as m } from "vue";
import { watch as p } from "vue";
import { nextTick as u } from "vue";
function E(c = {}, d = 0) {
  const { tableRef: h = null, hasPagination: b = true, bottomPadding: f = b ? 68 : 20 } = c, g = o(null), a = h || g, i = o(0), w = (e) => {
    if (!e) return null;
    if (e.$el && e.$el.classList.contains("el-table")) return e;
    const l = (t) => {
      if (t.$el && t.$el.classList.contains("el-table")) return t;
      if (t.$children) for (const H of t.$children) {
        const r = l(H);
        if (r) return r;
      }
      return null;
    };
    return l(e);
  }, T = () => {
    if (!a.value) return;
    const e = w(a.value);
    if (!e || !e.$el) return;
    const l = window.innerHeight, t = e.$el.getBoundingClientRect().top;
    return l - t - f - d;
  }, n = async () => {
    try {
      await u(() => {
        const e = T();
        e != null && (i.value = e);
      });
    } catch (e) {
      console.error("Failed to set table height:", e);
    }
  }, s = $.debounce(n, 100);
  return v(async () => {
    window.addEventListener("resize", s), await n();
  }), m(() => {
    window.removeEventListener("resize", s);
  }), p(() => a.value, async (e) => {
    e && e.$el && await n();
  }, { immediate: true, flush: "post" }), { tableRef: a, maxHeight: i, setTableHeight: n, updateTableHeight: async () => {
    await u(n);
  } };
}
export {
  E as u
};
