import C from "moment";
import { ref as c } from "vue";
import { watch as S } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as L } from "vue";
import { createVNode as t } from "vue";
import { createBlock as N } from "vue";
import { withCtx as r } from "vue";
import { withKeys as P } from "vue";
import { ElDatePicker as T } from "element-plus";
import { ElCol as D } from "element-plus";
import { ElRow as U } from "element-plus";
import { ElInput as B } from "element-plus";
import { vLoading as Q } from "element-plus";
import { s as Y } from "../../../../../../modules/enclosure-ship-summary-6941ca85.js";
import { _ as H, B as O, bU as u, fa as j, aV as q, D as K, C as R } from "../../../../../../shared/runtime.js";
import { P as f } from "../../../../../../modules/index-5b9e6004.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const M = { class: "head-container" }, $ = { __name: "header", setup(A) {
  const y = { dateTime: C().valueOf(), productionLineTypeEnum: void 0, workshopId: void 0, sendStatus: void 0, status: void 0, settled: void 0, projectName: void 0 }, { crud: s, query: a } = O(y), d = c({}), i = c(false);
  function h(o) {
    o === u.SETTLED.V ? (a.sendStatus = void 0, a.settled = 1) : (a.sendStatus = o, a.settled = void 0), s.toQuery();
  }
  S(() => a, (o) => {
    o && v();
  }, { immediate: true, deep: true });
  async function v() {
    try {
      i.value = true;
      const o = await Y(a);
      d.value = o || {};
    } catch (o) {
      console.log("获取累计发运", o);
    } finally {
      i.value = false;
    }
  }
  return (o, n) => {
    const g = T, w = x("common-radio-button"), m = D, V = U, E = B, k = Q;
    return p(), I("div", M, [_(L("div", null, [t(g, { modelValue: e(a).dateTime, "onUpdate:modelValue": n[0] || (n[0] = (l) => e(a).dateTime = l), type: "year", format: "YYYY", "value-format": "x", placeholder: "请选择", style: { width: "100px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), t(w, { modelValue: e(a).status, "onUpdate:modelValue": n[1] || (n[1] = (l) => e(a).status = l), options: [e(u).SHIPPING, e(u).SHIPPED], showOptionAll: "", type: "enum", class: "filter-item", onChange: h }, null, 8, ["modelValue", "options"]), t(q, { modelValue: e(a).workshopId, "onUpdate:modelValue": n[2] || (n[2] = (l) => e(a).workshopId = l), placeholder: "请选择车间", "workshop-type": e(j).ENCLOSURE.V, clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "workshop-type", "onChange"]), _((p(), N(V, { gutter: 20, class: "panel-group" }, { default: r(() => [t(m, { span: 12, class: "card-panel-col" }, { default: r(() => [t(e(f), { name: "累计发运量（米）", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.totalLength / 1e3 || 0, precision: e(K).MES_ENCLOSURE_L__M }, null, 8, ["end-val", "precision"])]), _: 1 }), t(m, { span: 12, class: "card-panel-col" }, { default: r(() => [t(e(f), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[k, e(s).loading]]), t(E, { modelValue: e(a).projectName, "onUpdate:modelValue": n[3] || (n[3] = (l) => e(a).projectName = l), placeholder: "项目搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: P(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(R))], 512), [[b, e(s).searchToggle]])]);
  };
} }, X = H($, [["__scopeId", "data-v-e0d77191"]]);
export {
  X as default
};
