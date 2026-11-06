import { i } from "../../../../../../modules/index-18acf776.js";
import { _ as s } from "../../../../../../shared/runtime.js";
import { ref as u } from "vue";
import { onMounted as c } from "vue";
import { onBeforeUnmount as l } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as _ } from "vue";
const d = { id: "echarts", style: { width: "550px", height: "200px" } }, f = { __name: "lineChart", setup(m) {
  const e = u();
  c(() => {
    r();
  }), l(() => {
    t();
  });
  function t() {
    e.value && (e.value.dispose(), e.value = null);
  }
  function n() {
    return [{ type: "category", data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"], boundaryGap: false }];
  }
  function o() {
    return [{ data: [820, 932, 901, 934, 1290, 1330, 1320], type: "line", areaStyle: {} }];
  }
  function a() {
    return [{ x: 0, y: 10, x2: 10, y2: 0, containLabel: true }];
  }
  function r() {
    e.value = i(document.getElementById("echarts")), e.value.clear(), e.value.setOption({ tooltip: { trigger: "item" }, grid: a(), yAxis: [{ show: true, type: "value", boundaryGap: [0, 0], position: "bottom" }], xAxis: n(), series: o() });
  }
  return (y, h) => (p(), _("div", d));
} }, g = s(f, [["__scopeId", "data-v-800f1bd2"]]);
export {
  g as default
};
