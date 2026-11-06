import { ref as p } from "vue";
import { watch as g } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as k } from "vue";
import { normalizeStyle as I } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as M } from "vue";
import { Fragment as q } from "vue";
import { vLoading as x } from "element-plus";
import { g as S } from "../../../modules/production-performance-dashboard-bb1cff92.js";
import { i as v } from "../../../shared/runtime.js";
import { u as O } from "../../../modules/use-chart-59e4b63c.js";
import C from "./average-loss-rate-detail.vue.js";
import "../../../modules/index-18acf776.js";
const z = { __name: "average-loss-rate", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, lossWorkshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(r) {
  const d = p(), u = p(false), m = p(false), n = r;
  g(() => n.lossWorkshopId, (l) => {
    d.value = l || n.query.workshopId, h();
  }, { deep: true }), g(() => n.query, (l) => {
    d.value = n.query.workshopId || void 0, h();
  }, { deep: true });
  const { getMyChart: w } = O({ elementId: "averageLossRateChart", fetchHook: h, initOption: { legend: { show: false }, tooltip: { trigger: "item", show: false }, title: { text: "全年平均损耗率", textStyle: { fontStyle: "normal", fontWeight: "bold", fontFamily: "sans-serif", fontSize: 12 } }, series: [{ type: "pie", radius: ["40%", "70%"], label: { show: true, position: "center", formatter: function(l) {
    return `${l.data.realValue}%`;
  }, fontSize: 16, fontWeight: "bold" }, data: [{ value: 65, realValue: 65, label: { normal: { show: true } } }, { value: 35, realValue: 35, itemStyle: { color: "#f1f1f1" }, label: { normal: { show: false } } }] }] } });
  async function h(l) {
    try {
      u.value = true;
      const s = l || w(), t = s.getOption(), a = await S({ ...n.query, workshopId: d.value }) || [], f = a == null ? void 0 : a.reduce((o, e) => v(e == null ? void 0 : e.sellMete) ? o + (e == null ? void 0 : e.sellMete) : o, 0), y = a == null ? void 0 : a.reduce((o, e) => v(e == null ? void 0 : e.mete) ? o + (e == null ? void 0 : e.mete) : o, 0), i = a == null ? void 0 : a.reduce((o, e) => v(e == null ? void 0 : e.outMete) ? o + (e == null ? void 0 : e.outMete) : o, 0);
      t.series[0].data[0].value = i ? Math.abs(((i - y - f * 1000) / i * 100).toFixed(2)) : 0, t.series[0].data[0].realValue = i ? ((i - y - f * 1000) / i * 100).toFixed(2) : 0, t.series[0].data[0].realValue >= 0 ? (t.series[0].data[1].value = 100 - t.series[0].data[0].value, t.series[0].data[1].realValue = 100 - t.series[0].data[0].realValue) : (t.series[0].data[1].value = 0, t.series[0].data[1].realValue = 0), s.setOption(t), s.on("click", function(o) {
        m.value = true;
      });
    } catch (s) {
      console.log(s, "获取全年平均损耗率图表失败");
    } finally {
      u.value = false;
    }
  }
  return (l, s) => {
    var a;
    const t = x;
    return b(), c(q, null, [k((b(), c("div", { style: I({ height: r.maxHeight + "px" }) }, s[1] || (s[1] = [V("div", { id: "averageLossRateChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[t, u.value]]), M(C, { visible: m.value, "onUpdate:visible": s[0] || (s[0] = (f) => m.value = f), query: r.query, workshopId: d.value, branchInfo: r.branchInfo, permission: (a = r.permission) == null ? void 0 : a.loss }, null, 8, ["visible", "query", "workshopId", "branchInfo", "permission"])], 64);
  };
} };
export {
  z as default
};
