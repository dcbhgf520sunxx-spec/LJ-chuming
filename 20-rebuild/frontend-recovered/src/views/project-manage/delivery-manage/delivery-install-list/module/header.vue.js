import { ref as g } from "vue";
import { watch as q } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as h } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as G } from "vue";
import { createVNode as o } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as _ } from "vue";
import { Fragment as F } from "vue";
import { withKeys as x } from "vue";
import { withCtx as i } from "vue";
import { ElInput as H } from "element-plus";
import { ElCol as X } from "element-plus";
import { ElRow as $ } from "element-plus";
import { vLoading as J } from "element-plus";
import { a as W } from "../../../../../modules/report-list-f9da4d70.js";
import { a as Y } from "../../../../../modules/area-ca564e60.js";
import { _ as Z, m as ee, K as R, kM as d, F as te, B as ae, q as ne, T as b, C as oe, G as le, E as re } from "../../../../../shared/runtime.js";
import p from "../../../components/Panel/index.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const ie = { class: "head-container" }, ue = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(Q) {
  const { deliveryInstallEnumArr: S } = ee("deliveryInstallEnumArr"), m = Q, N = { projectId: { value: void 0, resetAble: false }, productType: m.globalProject.projectType === R.STEEL.V ? d.ARTIFACT.V : te.BOX.V, monomerId: void 0, areaId: void 0, name: void 0, serialNumber: void 0 }, { crud: l, query: a } = ae(N), C = { key: "id", label: "name", value: "id" }, u = g([]), s = g({}), I = g(false), y = g([]);
  q(() => m.projectId, (t) => {
    t && (l.query.projectId = m.projectId, y.value = [], l.query.productType === d.ENCLOSURE.V && U(), l.toQuery());
  }, { immediate: true, deep: true }), q(a, (t) => {
    t && A();
  }, { immediate: true, deep: true });
  function k(t) {
    a.areaId = void 0, t === d.ENCLOSURE.V && U(), l.toQuery();
  }
  async function A() {
    if (a.projectId) {
      I.value = true;
      try {
        const t = await W(a);
        s.value = { ...t, receiveRate: t.receivingQuantity ? t.receivingQuantity / t.quantity * 100 : 0, installRate: t.receivingQuantity && t.installQuantity ? t.installQuantity / t.receivingQuantity * 100 : 0, totalQuantity: [{ quantity: t.quantity, unit: t.measureUnit, precision: 0 }, { quantity: t.mete, unit: t.accountingUnit, precision: 2 }], totalReceive: [{ quantity: t.receivingQuantity, unit: t.measureUnit, precision: 0 }, { quantity: t.receivingMete, unit: t.accountingUnit, precision: 2 }], totalInstall: [{ quantity: t.installQuantity, unit: t.measureUnit, precision: 0 }, { quantity: t.installMete, unit: t.accountingUnit, precision: 2 }], extraQuantity: [{ quantity: t.receivingQuantity ? t.receivingQuantity - (t.installQuantity || 0) : 0, unit: t.measureUnit, precision: 0 }, { quantity: t.receivingMete ? t.receivingMete - (t.installMete || 0) : 0, unit: t.accountingUnit, precision: 2 }] };
      } catch (t) {
        console.log("获取汇总数据", t);
      } finally {
        I.value = false;
      }
    }
  }
  function L(t) {
    u.value = t || [];
  }
  function P(t) {
    var n;
    u.value = ((n = y.value) == null ? void 0 : n.filter((f) => f.category === t)) || [], l.toQuery();
  }
  async function U() {
    var t;
    if (l.query.monomerId = void 0, u.value = [], m.projectId) try {
      const n = await Y(m.projectId) || [];
      y.value = n || [], l.query.category ? u.value = (t = y.value) == null ? void 0 : t.filter((f) => f.category === l.query.category) : u.value = y.value;
    } catch (n) {
      console.log("获取项目所有围护计划", n);
    }
  }
  return (t, n) => {
    const f = E("common-radio-button"), V = E("common-select"), j = H, c = X, M = $, K = E("print-table"), O = J, B = z("permission");
    return v(), w("div", ie, [h(G("div", null, [o(f, { modelValue: e(a).productType, "onUpdate:modelValue": n[0] || (n[0] = (r) => e(a).productType = r), options: e(S), type: "enum", class: "filter-item", onChange: k }, null, 8, ["modelValue", "options"]), e(a).productType !== e(d).ENCLOSURE.V ? (v(), T(e(ne), { key: 0, ref: "monomerSelectRef", modelValue: e(a).monomerId, "onUpdate:modelValue": n[1] || (n[1] = (r) => e(a).monomerId = r), "project-id": e(a).projectId, "main-product-type": Q.globalProject.projectType === e(R).STEEL.V ? e(a).productType : "", default: false, clearable: "", class: "filter-item", onChange: e(l).toQuery, onGetAreaInfo: L }, null, 8, ["modelValue", "project-id", "main-product-type", "onChange"])) : _("", true), e(a).productType !== e(d).ENCLOSURE.V ? (v(), T(V, { key: 1, modelValue: e(a).areaId, "onUpdate:modelValue": n[2] || (n[2] = (r) => e(a).areaId = r), options: u.value, type: "other", dataStructure: C, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : _("", true), e(a).productType === e(d).ENCLOSURE.V ? (v(), w(F, { key: 2 }, [o(V, { modelValue: e(a).category, "onUpdate:modelValue": n[3] || (n[3] = (r) => e(a).category = r), options: e(b).ENUM, "unshow-options": [e(b).STRUCTURE.K, e(b).BRIDGE.K], type: "enum", size: "default", clearable: "", placeholder: "请选择围护类型", class: "filter-item", style: { width: "200px" }, onChange: P }, null, 8, ["modelValue", "options", "unshow-options"]), o(V, { modelValue: e(a).areaId, "onUpdate:modelValue": n[4] || (n[4] = (r) => e(a).areaId = r), options: u.value, type: "other", dataStructure: C, size: "default", clearable: "", placeholder: "请选择批次", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 64)) : _("", true), o(j, { modelValue: e(a).serialNumber, "onUpdate:modelValue": n[5] || (n[5] = (r) => e(a).serialNumber = r), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: x(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(j, { modelValue: e(a).name, "onUpdate:modelValue": n[6] || (n[6] = (r) => e(a).name = r), modelModifiers: { trim: true }, placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: x(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(oe)), e(le)(e(l).permission.get) ? h((v(), T(M, { key: 3, gutter: 20, class: "panel-group" }, { default: i(() => [o(c, { span: 4, class: "card-panel-col" }, { default: i(() => [o(e(p), { name: "清单总量", "text-color": "#626262", "num-color": "#1890ff", "num-arr": s.value.totalQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), o(c, { span: 4, class: "card-panel-col" }, { default: i(() => [o(e(p), { name: "已收货", "text-color": "#626262", "num-color": "#1890ff", "num-arr": s.value.totalReceive, precision: 0, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), o(c, { span: 4, class: "card-panel-col" }, { default: i(() => [o(e(p), { name: "收货率(%)", "text-color": "#626262", "num-color": "#1890ff", "end-val": s.value.receiveRate || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), o(c, { span: 4, class: "card-panel-col" }, { default: i(() => [o(e(p), { name: "已安装", "text-color": "#626262", "num-color": "#1890ff", "num-arr": s.value.totalInstall, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 }), o(c, { span: 4, class: "card-panel-col" }, { default: i(() => [o(e(p), { name: "安装率(%)", "text-color": "#626262", "num-color": "#1890ff", "end-val": s.value.installRate || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), o(c, { span: 4, class: "card-panel-col" }, { default: i(() => [o(e(p), { name: "工地库存", "text-color": "#626262", "num-color": "#1890ff", "num-arr": s.value.extraQuantity, "is-array": "" }, null, 8, ["num-arr"])]), _: 1 })]), _: 1 })), [[O, I.value]]) : _("", true)], 512), [[D, e(l).searchToggle]]), o(e(re), null, { viewLeft: i(() => [h(o(K, { "api-key": "deliveryInstallList", params: { ...e(a), queryType: 1 }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[B, e(l).permission.print]])]), _: 1 })]);
  };
} }, fe = Z(ue, [["__scopeId", "data-v-32d16a51"]]);
export {
  fe as default
};
