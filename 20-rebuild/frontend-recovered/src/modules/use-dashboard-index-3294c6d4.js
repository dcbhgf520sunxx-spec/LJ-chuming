import { m as w } from "../shared/runtime.js";
import { R as i } from "./raf-ac2cc4f2.js";
import { ref as v } from "vue";
import { watch as I } from "vue";
import { computed as r } from "vue";
import { onMounted as y } from "vue";
import { onUnmounted as H } from "vue";
function O({ headRef: f, scrollBoxRef: h, crud: e, CRUD: g, pageSize: m = 100, intervalTime: u = 250, beforeRefreshHook: p }) {
  const { globalProjectId: c } = w(["globalProjectId"]), o = v([]);
  I(c, (t) => {
    o.value = [], e.query.monomerId = void 0, e.query.areaId = void 0;
  }, { immediate: true });
  const l = r(() => f.value ? (s(), f.value.boxScale) : 1), x = r(() => ({ "font-size": `${(16 * l.value).toFixed(0)}px`, width: `${(120 * l.value).toFixed(0)}px`, height: `${(120 * l.value).toFixed(0)}px` }));
  y(() => {
    window.addEventListener("resize", s, { passive: false });
  }), H(() => {
    window.removeEventListener("resize", s);
  });
  function s() {
    i.clearInterval();
    const t = 200, a = h.value;
    if (!a || !e.page.hasNextPage || a.scrollHeight > a.clientHeight + t) return;
    let b = 0;
    console.log(u), i.setInterval(() => {
      a && e.page.hasNextPage && a.scrollHeight < a.clientHeight + t && ++b <= 10 ? d() : i.clearInterval();
    }, u);
  }
  const n = v(false);
  async function d() {
    if (e.firstLoaded && e.page.hasNextPage && !n.value) {
      n.value = true;
      try {
        await e.pageChangeHandler(e.page.page + 1);
      } finally {
        n.value = false;
      }
    }
  }
  return g.HOOK.beforeRefresh = () => {
    typeof p == "function" && p(), e.page.size = m, e.page.page === 1 && (o.value = []);
  }, g.HOOK.afterRefresh = () => {
    e.data.forEach((t) => {
      o.value.push(t);
    });
  }, { globalProjectId: c, boxStyle: x, load: d, boardList: o, isLoading: r(() => n.value) };
}
export {
  O as u
};
