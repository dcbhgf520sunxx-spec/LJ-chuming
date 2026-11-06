import { i as g } from "../../../../../modules/index-18acf776.js";
import { inject as w } from "vue";
import { ref as p } from "vue";
import { computed as i } from "vue";
import { watch as S } from "vue";
import { onMounted as b } from "vue";
import { onBeforeUnmount as L } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as A } from "vue";
import { normalizeStyle as B } from "vue";
const M = ["id"], k = { __name: "chart", props: { id: { type: String, required: true }, width: { type: String, default: "100%" }, height: { type: String, default: "400px" } }, setup(n) {
  const d = n, f = w("projectInfo"), t = p(), a = p([]), o = i(() => a.value.map((e) => e.provinceName)), h = i(() => a.value.map((e) => e.quantity)), m = i(() => {
    let e = Math.max(...o.value.map((c) => c.length), 2);
    return e > 5 && (e = 5), e * 16 + 10;
  }), v = i(() => (a.value.length || 4) * 60);
  S(() => f, (e) => {
    a.value = e.provinceList || [], x();
  }, { deep: true }), b(() => {
    u();
  }), L(() => {
    y();
  });
  function y() {
    t.value && (t.value.dispose(), t.value = null);
  }
  function x() {
    try {
      t.value ? t.value.setOption({ grid: l(), yAxis: r(), series: s() }) : u(), t.value.resize({ height: v.value });
    } catch (e) {
      console.log("更新chart", e);
    }
  }
  function r() {
    return [{ type: "category", data: [...o.value], axisLine: { show: false }, axisTick: [{ show: false }], axisLabel: { textStyle: { fontSize: "14" } } }];
  }
  function s() {
    return [{ name: "", type: "bar", tooltip: { show: false }, barMinHeight: 30, barWidth: 40, barMaxWidth: 100, data: [...h.value], itemStyle: { normal: { color: "#1890ff", label: { show: true, position: "inside", textStyle: { fontSize: "14" } } } } }];
  }
  function l() {
    return [{ x: m.value, y: 0, x2: 10, y2: 0 }];
  }
  function u() {
    t.value = g(document.getElementById(d.id)), t.value.clear(), t.value.setOption({ tooltip: { trigger: "item" }, grid: l(), xAxis: [{ show: false, type: "value", boundaryGap: [0, 0], position: "top" }], yAxis: r(), series: s() });
  }
  return (e, c) => (z(), A("div", { id: n.id, style: B({ width: n.width }) }, null, 12, M));
} };
export {
  k as default
};
