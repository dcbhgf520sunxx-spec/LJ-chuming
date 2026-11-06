import { m as x } from "../shared/runtime.js";
import { R as l } from "./raf-ac2cc4f2.js";
import { ref as b } from "vue";
import { watch as w } from "vue";
import { computed as u } from "vue";
import { onMounted as I } from "vue";
import { onUnmounted as H } from "vue";
function L({ headRef: i, scrollBoxRef: d, crud: e, CRUD: r, pageSize: h = 100, intervalTime: f = 250, beforeRefreshHook: g }) {
  const { globalProjectId: p } = x(["globalProjectId"]), o = b([]);
  w(p, (t) => {
    o.value = [], e.query.monomerId = void 0, e.query.areaId = void 0;
  }, { immediate: true });
  const n = u(() => i.value ? (s(), i.value.boxScale) : 1), m = u(() => ({ "font-size": `${(16 * n.value).toFixed(0)}px`, width: `${(120 * n.value).toFixed(0)}px`, height: `${(120 * n.value).toFixed(0)}px` }));
  I(() => {
    window.addEventListener("resize", s, { passive: false });
  }), H(() => {
    window.removeEventListener("resize", s);
  });
  function s() {
    l.clearInterval();
    const t = 200, a = d.value;
    if (!a || !e.page.hasNextPage || a.scrollHeight > a.clientHeight + t) return;
    let v = 0;
    console.log(f), l.setInterval(() => {
      a && e.page.hasNextPage && a.scrollHeight < a.clientHeight + t && ++v <= 10 ? c() : l.clearInterval();
    }, f);
  }
  async function c() {
    e.firstLoaded && e.page.hasNextPage && await e.pageChangeHandler(++e.page.page);
  }
  return r.HOOK.beforeRefresh = () => {
    typeof g == "function" && g(), e.page.size = h, e.page.page === 1 && (o.value = []);
  }, r.HOOK.afterRefresh = () => {
    e.data.forEach((t) => {
      o.value.push(t);
    });
  }, { globalProjectId: p, boxStyle: m, load: c, boardList: o };
}
export {
  L as u
};
