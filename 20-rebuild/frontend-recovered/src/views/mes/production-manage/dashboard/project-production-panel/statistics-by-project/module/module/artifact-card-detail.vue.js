import { ref as c } from "vue";
import { watch as I } from "vue";
import { computed as h } from "vue";
import { unref as r } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as g } from "vue";
import { createBlock as k } from "vue";
import { withCtx as y } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as n } from "vue";
import { normalizeStyle as R } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as A } from "vue";
import { isRef as H } from "vue";
import { ElTableColumn as q } from "element-plus";
import E from "./process-card-detail.vue.js";
import { g as M } from "../../../../../../../../modules/project-production-panel-fb6946a2.js";
import { _ as z, u as T, o as G, G as J, pI as O, i as N, b as U } from "../../../../../../../../shared/runtime.js";
const F = ["onClick"], K = { class: "title-container", style: { "margin-top": "40px", "margin-bottom": "10px" } }, W = { class: "title-left" }, X = { class: "title-text" }, Y = { __name: "artifact-card-detail", props: { visible: { type: Boolean, default: false }, productId: { type: Number } }, emits: ["update:visible"], setup(C, { emit: L }) {
  const b = c(), l = c({}), B = L, u = C, p = c(false), { visible: d, handleClose: P } = T({ emit: B, props: u, field: "visible" }), { maxHeight: V } = G({ extraBox: ["#el-drawer__title"], extraHeight: 500, wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b);
  I(() => u.visible, (e) => {
    if (e) {
      $();
      return;
    }
    p.value = false, l.value = {};
  }, { immediate: true });
  const f = c(false), _ = c([]);
  async function $() {
    if (J(O.detailLingBuJian)) try {
      f.value = true;
      const e = { productId: u.productId }, t = await M(e);
      _.value = D(t);
    } catch (e) {
      console.log("获取零部件生产状态", e);
    } finally {
      f.value = false;
    }
  }
  function D(e) {
    const t = [], a = { ...e };
    return delete a.assembleList, delete a.machinePartList, t.push(a), e.assembleList && Array.isArray(e.assembleList) && e.assembleList.forEach((o) => {
      o.commonSerialNumber = o.serialNumber, delete o.serialNumber, t.push(o);
    }), e.machinePartList && Array.isArray(e.machinePartList) && e.machinePartList.forEach((o) => {
      o.commonSerialNumber = o.serialNumber, delete o.serialNumber, t.push(o);
    }), t;
  }
  const Q = (e) => {
    l.value = e, p.value = true;
  }, w = h(() => {
    const { companyQuantity: e, quantity: t } = r(l) || {};
    return N(e) && N(t) ? `${e}/${t}` : "";
  }), S = h(() => {
    var m;
    if (U(r(l))) return;
    const { name: e, serialNumber: t, commonSerialNumber: a } = r(l);
    return ((m = r(l).sourceRow) == null ? void 0 : m.name) ? `${e} ${t} ${r(w)}` : `${a} ${r(w)}`;
  });
  return (e, t) => {
    const a = q, o = v("common-table"), m = v("common-drawer");
    return g(), k(m, { ref_key: "drawerRef", ref: b, title: "零部件生产状态", modelValue: r(d), "onUpdate:modelValue": t[0] || (t[0] = (s) => H(d) ? d.value = s : null), contentLoading: f.value, direction: "rtl", "before-close": r(P), size: "100%" }, { content: y(() => [i(o, { data: _.value, "max-height": r(V), style: { width: "100%", margin: "10px 0" } }, { default: y(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), i(a, { key: "anme", prop: "name", "show-overflow-tooltip": true, align: "center", label: "名称", "min-width": "140" }), i(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "编号", "min-width": "140" }), i(a, { key: "commonSerialNumber", prop: "commonSerialNumber", "show-overflow-tooltip": true, align: "center", label: "零部件编号", "min-width": "140" }), i(a, { key: "specification", prop: "specification", "show-overflow-tooltip": true, align: "center", label: "规格", "min-width": "140" }), i(a, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "140" }), i(a, { key: "quantity", align: "center", prop: "quantity", "show-overflow-tooltip": true, label: "数量", "min-width": "140" }), i(a, { key: "taskQuantity", align: "center", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数", "min-width": "140" }), i(a, { key: "companyQuantity", align: "center", prop: "companyQuantity", "show-overflow-tooltip": true, label: "完成数量", "min-width": "140" }, { default: y(({ row: s }) => [n("div", { style: R({ color: s.boolCompany ? "#00751f" : "#ff0f1a" }), class: "num-td", onClick: (Z) => Q(s) }, x(s.companyQuantity), 13, F)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), n("div", null, [n("div", K, [n("span", W, [n("span", X, x(S.value || "工序详情"), 1), t[1] || (t[1] = n("span", { class: "title-red" }, "*请点击上方表格完成数量，查看任务工序详情", -1))])]), p.value ? (g(), k(E, { key: 0, "detail-row": l.value }, null, 8, ["detail-row"])) : A("", true)])]), _: 1 }, 8, ["modelValue", "contentLoading", "before-close"]);
  };
} }, oe = z(Y, [["__scopeId", "data-v-27598c92"]]);
export {
  oe as default
};
