import { D as d } from "../../../../../../shared/runtime.js";
import { i as _ } from "../../../../../../modules/index-18acf776.js";
import { inject as b } from "vue";
import { ref as f } from "vue";
import { computed as o } from "vue";
import { watch as L } from "vue";
import { onMounted as M } from "vue";
import { onBeforeUnmount as q } from "vue";
import { openBlock as W } from "vue";
import { createElementBlock as k } from "vue";
import { normalizeStyle as z } from "vue";
const A = ["id"], O = { __name: "chart", props: { id: { type: String, required: true }, width: { type: String, default: "100%" }, height: { type: String, default: "400px" } }, emits: ["success"], setup(n, { emit: h }) {
  const m = n, p = h, v = b("projectInfo"), e = f(), i = f([]), a = o(() => i.value.map((t) => t.name)), y = o(() => i.value.map((t) => ({ value: t.quantity, ...t }))), g = o(() => {
    let t = Math.max(...a.value.map((c) => c.length), 2);
    return t > 5 && (t = 5), t * 16 + 10;
  }), x = o(() => (i.value.length || 4) * 60);
  L(() => v, (t) => {
    i.value = t.provinceList || [], S();
  }, { deep: true }), M(() => {
    l();
  }), q(() => {
    w();
  });
  function w() {
    e.value && (e.value.dispose(), e.value = null);
  }
  function S() {
    try {
      e.value ? e.value.setOption({ grid: u(), yAxis: r(), series: s() }) : l(), e.value.resize({ height: x.value });
    } catch (t) {
      console.log("更新chart", t);
    }
  }
  function r() {
    return [{ type: "category", data: [...a.value], axisLine: { show: false }, axisTick: [{ show: false }], axisLabel: { textStyle: { fontSize: "14" } } }];
  }
  function s() {
    return [{ name: "", type: "bar", tooltip: { show: true, formatter(t) {
      if (console.log(t), t.value) return t.data.name + "：" + t.data.quantity + " / " + (t.data.mete / 1e3).toFixed(d.COM_WT__KG);
    } }, barMinHeight: 80, barWidth: 40, barMaxWidth: 100, data: [...y.value], itemStyle: { normal: { color: "#1890ff", label: { show: true, position: "insideLeft", textStyle: { fontSize: "12" }, formatter(t) {
      if (console.log(t), t.value) return t.data.quantity + " / " + (t.data.mete / 1e3).toFixed(d.COM_WT__KG);
    } } } } }];
  }
  function u() {
    return [{ x: g.value, y: 0, x2: 10, y2: 0 }];
  }
  function l() {
    e.value = _(document.getElementById(m.id)), e.value.clear(), e.value.setOption({ tooltip: { trigger: "item" }, grid: u(), xAxis: [{ show: false, type: "value", boundaryGap: [0, 0], position: "top" }], yAxis: r(), series: s() }), e.value.on("click", function(t) {
      console.log(t), p("success", t);
    });
  }
  return (t, c) => (W(), k("div", { id: n.id, style: z({ width: n.width }) }, null, 12, A));
} };
export {
  O as default
};
