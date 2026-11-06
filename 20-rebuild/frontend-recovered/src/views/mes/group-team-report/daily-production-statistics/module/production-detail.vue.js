import { watch as q } from "vue";
import { ref as m } from "vue";
import { inject as L } from "vue";
import { computed as F } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as g } from "vue";
import { createBlock as w } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as C } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as i } from "vue";
import { unref as n } from "vue";
import { withDirectives as j } from "vue";
import { isRef as O } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { b as K } from "../../../../../modules/daily-production-statistics-18379024.js";
import { _ as Q, u as W, o as X, fv as Y, q as Z, nC as ee } from "../../../../../shared/runtime.js";
const ae = { class: "header" }, te = { __name: "production-detail", props: { modelValue: { type: Boolean, require: true }, packDetailData: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(s, { emit: S }) {
  const B = S, D = s, { visible: r, handleClose: H } = W({ emit: B, props: D, showHook: R });
  q(r, (u) => {
    u && v();
  });
  const x = m([]), k = m(), _ = m(false), d = L("query"), y = m(), c = m(), V = F(() => ({ projectId: c.value || void 0, workShopId: D.packDetailData.workShopId || void 0, teamId: D.packDetailData.teamId || void 0, monomerId: y.value || void 0, dateTime: d.dateTime || void 0, meteUnitEnum: d.meteUnitEnum || void 0 })), { maxHeight: M } = X({ mainBox: ".daily-production-statistics-production-detail", extraBox: [".el-drawer__header", ".header"], wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, () => k.value.loaded);
  async function v() {
    if (!r.value || _.value) return;
    let u = [];
    _.value = true;
    try {
      u = await K({ ...V.value }) || [];
    } catch (a) {
      console.log(a);
    } finally {
      x.value = u, _.value = false;
    }
  }
  function R() {
    c.value = (d == null ? void 0 : d.projectId) || void 0, v();
  }
  return (u, a) => {
    const I = $, T = b("print-table"), h = G, P = b("common-table"), U = b("common-drawer"), z = A("permission"), E = J;
    return g(), w(U, { ref_key: "drawerRef", ref: k, title: "焊接明细", "close-on-click-modal": false, modelValue: n(r), "onUpdate:modelValue": a[2] || (a[2] = (l) => O(r) ? r.value = l : null), direction: "rtl", "before-close": n(H), "custom-class": "daily-production-statistics-production-detail", size: "80%" }, { titleAfter: o(() => {
      var l, e;
      return [(l = s.packDetailData) != null && l.workShopName ? (g(), w(I, { key: 0, effect: "plain", size: "large" }, { default: o(() => {
        var t;
        return [N("车间：" + p((t = s.packDetailData) == null ? void 0 : t.workShopName), 1)];
      }), _: 1 })) : C("", true), (e = s.packDetailData) != null && e.teamName ? (g(), w(I, { key: 1, effect: "plain", size: "large" }, { default: o(() => {
        var t;
        return [N("班组：" + p((t = s.packDetailData) == null ? void 0 : t.teamName), 1)];
      }), _: 1 })) : C("", true)];
    }), titleRight: o(() => a[3] || (a[3] = [])), content: o(() => {
      var l;
      return [f("div", ae, [f("div", null, [i(n(Y), { modelValue: c.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => c.value = e), class: "filter-item", style: { width: "300px" }, clearable: "", placeholder: "可选择项目搜索", onChange: v }, null, 8, ["modelValue"]), i(n(Z), { ref: "monomerRef", modelValue: y.value, "onUpdate:modelValue": a[1] || (a[1] = (e) => y.value = e), "project-id": c.value, placeholder: "可选择单体", clearable: "", default: false, class: "filter-item", style: { width: "200px", "margin-left": "10px" }, onChange: v }, null, 8, ["modelValue", "project-id"])]), j(i(T, { "api-key": "mesDailyStatisticsProductionDetail", params: { ...V.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[z, (l = n(ee)) == null ? void 0 : l.productionDetailPrint]])]), j((g(), w(P, { data: x.value, "empty-text": "暂无数据", "max-height": n(M) }, { default: o(() => [i(h, { label: "序号", type: "index", align: "center", width: "60" }), i(h, { prop: "classificationName", label: "名称", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => [f("span", null, p(e.classificationName || "-"), 1)]), _: 1 }), i(h, { prop: "dayTotalMete", label: "当日焊接新增重量", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => {
        var t;
        return [f("span", null, p(((t = e.dayTotalMete) == null ? void 0 : t.toFixed(2)) || "-"), 1)];
      }), _: 1 }), i(h, { prop: "totalMete", label: "焊接总重量", align: "center", "show-overflow-tooltip": "" }, { default: o(({ row: e }) => {
        var t;
        return [f("span", null, p(((t = e.totalMete) == null ? void 0 : t.toFixed(2)) || "-"), 1)];
      }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[E, _.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = Q(te, [["__scopeId", "data-v-89983e64"]]);
export {
  ne as default
};
