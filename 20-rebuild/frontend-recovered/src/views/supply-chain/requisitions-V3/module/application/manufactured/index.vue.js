import { ref as C } from "vue";
import { computed as I } from "vue";
import { provide as ee } from "vue";
import { watch as T } from "vue";
import { resolveComponent as te } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as ae } from "vue";
import { createVNode as u } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as U } from "vue";
import { unref as h } from "vue";
import { createBlock as R } from "vue";
import { createCommentVNode as H } from "vue";
import { withKeys as ie } from "vue";
import { withModifiers as F } from "vue";
import { createTextVNode as b } from "vue";
import { resolveDynamicComponent as le } from "vue";
import { ElMessage as V } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElPopconfirm as ne } from "element-plus";
import { ElBadge as se } from "element-plus";
import { ElForm as re } from "element-plus";
import { _ as de, i as m, tB as ue, w1 as j, o as ce, wb as y, V as E, fv as fe, bZ as pe, mw as me, v0 as B, wp as ye, b as P } from "../../../../../../shared/runtime.js";
import _e from "../components/common-wrapper.vue.js";
import he from "./module/enclosure-table.vue.js";
import ve from "./module/structure-table.vue.js";
import Ce from "../components/confirm-dialog.vue.js";
import "../components/common-footer.vue.js";
const be = { class: "manuf-requisitions-application-container" }, Ie = { class: "filter-container" }, Te = { class: "filter-left-box" }, ge = { class: "head-container", style: { "margin-bottom": "0px" } }, Ue = { class: "filter-right-box" }, Ee = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, formHistory: { type: Object } }, emits: ["success"], setup(N, { expose: k, emit: O }) {
  const S = O, p = N, L = { list: [] }, q = C(), _ = C(), w = C(), o = C({}), x = C(false), i = C([]), A = I(() => {
    let a = false;
    return m(p.formHistory) && (t.finishedProductType === p.formHistory.finishedProductType ? a = true : a = false), a;
  });
  ee("customQuery", I(() => o.value));
  const { form: t, FORM: M } = ue({ title: "制成品申购", defaultForm: L, api: p.isEdit ? j.edit : j.add }, w, p.detail);
  T(() => p.detail, (a = {}) => {
    t.purchaseListObj = {}, t.finishedProductType = a.finishedProductType, t.materialType = a.materialType, t.branchCompanyId = a.branchCompanyId, o.value.branchCompanyId = a.branchCompanyId;
  }, { deep: true, immediate: true }), T(() => t.branchCompanyId, (a) => {
    o.value.projectId = void 0;
  });
  const { maxHeight: z } = ce({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false, minHeight: 300, extraHeight: 200 }), W = I(() => {
    switch (t.finishedProductType) {
      case y.STRUC_MANUFACTURED.V:
        return ve;
      case y.ENCL_MANUFACTURED.V:
        return he;
      default:
        return;
    }
  }), D = I(() => m(t.list) ? Object.keys(t.list).length : 0);
  function K() {
    var a, e, r, d;
    if (_.value) {
      const n = _.value.selectList;
      if (!(n != null && n.length)) {
        V.warning("请选择数据");
        return;
      }
      if (i.value = [...i.value, ...E(n)], t.finishedProductType === y.STRUC_MANUFACTURED.V) {
        const l = [];
        if (m(i.value)) for (let s = 0; s < i.value.length; s++) l.indexOf((a = i.value[s]) == null ? void 0 : a.productId) === -1 ? l.push((e = i.value[s]) == null ? void 0 : e.productId) : (i.value.splice(s, 1), s--);
      } else if (m(i.value)) {
        const l = [];
        for (let s = 0; s < i.value.length; s++) l.indexOf((r = i.value[s]) == null ? void 0 : r.id) === -1 ? l.push((d = i.value[s]) == null ? void 0 : d.id) : (i.value.splice(s, 1), s--);
      }
      m(i.value) && i.value.forEach((l) => {
        t.finishedProductType === y.STRUC_MANUFACTURED.V ? (l.basicClass = B.STRUC_MANUFACTURED.V, l.weight = l.netWeight) : l.basicClass = B.ENCL_MANUFACTURED.V;
      }), t.list = E(i.value), t.type = ye.MANUFACTURED.V;
    }
  }
  function $({ id: a, quantity: e }, r, d) {
    t.finishedProductType === y.STRUC_MANUFACTURED.V ? (t.list.splice(t.list.findIndex((n) => n.productId === r.productId), 1), i.value.splice(i.value.findIndex((n) => n.productId === r.productId), 1)) : (t.list.splice(t.list.findIndex((n) => n.id === r.id), 1), i.value.splice(i.value.findIndex((n) => n.id === r.id), 1)), _.value.deleteRow(r);
  }
  function Q() {
    t.list = [], i.value = [], _.value.deleteAll();
  }
  function v() {
    var a;
    (a = _.value) == null || a.refreshList();
  }
  function Z() {
    var a;
    (a = _.value) == null || a.refresh();
  }
  function G() {
    o.value.projectId = void 0, o.value.monomerId = void 0, o.value.areaId = void 0, o.value.serialNumber = void 0, Z();
  }
  async function J() {
    let a = true;
    a = Y(), x.value = a;
  }
  T(() => t.finishedProductType, (a, e) => {
    a && e && (t.list = [], i.value = []);
  }, { immediate: true }), M.HOOK.beforeToEdit = async (a, e) => {
    var r, d, n;
    m(e.list) && (o.value.projectId = (d = (r = e.list[0]) == null ? void 0 : r.project) == null ? void 0 : d.id, e.list.forEach((l) => {
      l.name = l.manufacturedName, l.serialNumber = l.manufacturedSn, e.finishedProductType === y.STRUC_MANUFACTURED.V && (l.productId = l.artifactEnclosureId, l.netWeight = l.weight), e.finishedProductType === y.ENCL_MANUFACTURED.V && (l.id = l.artifactEnclosureId, l.category = l.manufacturedType);
    }), i.value = E((n = p.formHistory) == null ? void 0 : n.list));
  };
  function X() {
    var a;
    t.finishedProductType === p.formHistory.finishedProductType ? (A.value = true, t.list = E((a = p.formHistory) == null ? void 0 : a.list), i.value = [...t.list]) : A.value = false;
  }
  T(() => o.value.projectId, (a, e) => {
    m(e) && (i.value = [], t.list = [], v());
  }), M.HOOK.afterSubmit = () => {
    S("success");
  };
  function Y() {
    return P(t.branchCompanyId) ? (V.warning("请选择申购单位"), false) : P(t.list) ? (V.warning("请选择数据"), false) : true;
  }
  return k({ refreshList: v }), (a, e) => {
    const r = oe, d = te("common-button"), n = ne, l = se, s = re;
    return g(), ae("div", be, [u(_e, { ref_key: "commonWrapperRef", ref: q, "show-footer": false }, { default: f(() => [U("div", Ie, [U("div", Te, [U("div", ge, [u(fe, { modelValue: o.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (c) => o.value.projectId = c), "branch-company-id": h(t).branchCompanyId, class: "filter-item", clearable: "", filterable: "", placeholder: "可选择项目搜索", onChange: v }, null, 8, ["modelValue", "branch-company-id"]), h(m)(o.value.projectId) && h(t).finishedProductType === h(y).STRUC_MANUFACTURED.V ? (g(), R(pe, { key: 0, areaId: o.value.areaId, "onUpdate:areaId": e[1] || (e[1] = (c) => o.value.areaId = c), monomerId: o.value.monomerId, "onUpdate:monomerId": e[2] || (e[2] = (c) => o.value.monomerId = c), areaType: h(me).OUTSOURCE.V, "project-id": o.value.projectId, areaClearable: "", clearable: "", onChange: v }, null, 8, ["areaId", "monomerId", "areaType", "project-id"])) : H("", true), u(r, { modelValue: o.value.serialNumber, "onUpdate:modelValue": e[3] || (e[3] = (c) => o.value.serialNumber = c), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入编号搜索", size: "default", style: { width: "200px" }, onKeyup: ie(v, ["enter"]) }, null, 8, ["modelValue"]), u(d, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: F(v, ["stop"]) }, { default: f(() => e[5] || (e[5] = [b(" 搜索 ")])), _: 1, __: [5] }), u(d, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: F(G, ["stop"]) }, { default: f(() => e[6] || (e[6] = [b(" 重置 ")])), _: 1, __: [6] })])]), U("div", Ue, [N.isEdit && A.value ? (g(), R(n, { key: 0, title: "是否恢复全部数据吗?", onConfirm: X }, { reference: f(() => [u(d, { class: "filter-item", size: "default", type: "primary" }, { default: f(() => e[7] || (e[7] = [b(" 恢复 ")])), _: 1, __: [7] })]), _: 1 })) : H("", true), u(d, { class: "filter-item", icon: "el-icon-plus", size: "default", type: "warning", onClick: K }, { default: f(() => e[8] || (e[8] = [b(" 选择加入 ")])), _: 1, __: [8] }), u(l, { hidden: D.value < 1, max: 99, value: D.value, style: { "margin-right": "10px" } }, { default: f(() => [u(d, { class: "filter-item", icon: "el-icon-shopping-cart-2", size: "default", type: "success", onClick: J }, { default: f(() => e[9] || (e[9] = [b(" 申购车 ")])), _: 1, __: [9] })]), _: 1 }, 8, ["hidden", "value"])])]), u(s, { ref_key: "formRef", ref: w, model: h(t) }, { default: f(() => [(g(), R(le(W.value), { ref_key: "tableRef", ref: _, "max-height": h(z), selectListHistory: i.value }, null, 8, ["max-height", "selectListHistory"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 512), u(Ce, { modelValue: x.value, "onUpdate:modelValue": e[4] || (e[4] = (c) => x.value = c), "is-manufactured": "", onManufDel: $, onManufDelAll: Q }, null, 8, ["modelValue"])]);
  };
} }, De = de(Ee, [["__scopeId", "data-v-fd06f316"]]);
export {
  De as default
};
