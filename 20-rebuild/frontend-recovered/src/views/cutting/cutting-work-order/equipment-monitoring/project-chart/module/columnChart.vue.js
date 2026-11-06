import { i as s } from "../../../../../../modules/index-18acf776.js";
import { _ as u } from "../../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { onMounted as l } from "vue";
import { onBeforeUnmount as _ } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
const m = { id: "myEcharts", style: { width: "550px", height: "230px" } }, h = { __name: "columnChart", setup(f) {
  const t = c();
  l(() => {
    i();
  }), _(() => {
    e();
  });
  function e() {
    t.value && (t.value.dispose(), t.value = null);
  }
  function r() {
    return [{ type: "category", data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"] }];
  }
  function o() {
    return [{ show: true, type: "value" }];
  }
  function n() {
    return [{ barMinHeight: 30, barWidth: 40, barMaxWidth: 100, data: [120, 100, 90, 80, 70, 110, 130], type: "bar", showBackground: true, backgroundStyle: { color: "rgba(180, 180, 180, 0.2)" } }];
  }
  function a() {
    return [{ x: 0, y: 8, x2: 20, y2: 0, containLabel: true }];
  }
  function i() {
    t.value = s(document.getElementById("myEcharts")), t.value.clear(), t.value.setOption({ tooltip: { trigger: "item" }, grid: a(), yAxis: o(), xAxis: r(), series: n() });
  }
  return (y, x) => (d(), p("div", m));
} }, B = u(h, [["__scopeId", "data-v-25906e28"]]);
export {
  B as default
};
