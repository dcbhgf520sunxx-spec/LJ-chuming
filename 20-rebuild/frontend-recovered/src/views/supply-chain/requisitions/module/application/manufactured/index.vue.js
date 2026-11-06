import { ref as p } from "vue";
import { provide as $ } from "vue";
import { computed as O } from "vue";
import { watch as L } from "vue";
import { watchEffect as X } from "vue";
import { nextTick as Z } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as J } from "vue";
import { createVNode as n } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as _ } from "vue";
import { unref as c } from "vue";
import { createBlock as W } from "vue";
import { createCommentVNode as Y } from "vue";
import { withKeys as ee } from "vue";
import { withModifiers as C } from "vue";
import { createTextVNode as b } from "vue";
import { resolveDynamicComponent as te } from "vue";
import { ElMessage as I } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElBadge as se } from "element-plus";
import { ElForm as ie } from "element-plus";
import { _ as re, tB as oe, wx as V, o as ne, a$ as ue, v0 as k, i as E, V as B, iX as m, b as g, bZ as le, mw as ce } from "../../../../../../shared/runtime.js";
import de from "../components/common-wrapper.vue.js";
import pe from "./module/enclosure-table.vue.js";
import M from "./module/structure-table.vue.js";
import me from "../components/confirm-dialog.vue.js";
import "../components/common-footer.vue.js";
import "../../../../../../modules/use-approval-cfg-0a67817c.js";
const fe = { class: "manuf-requisitions-application-container" }, he = { class: "filter-container" }, _e = { class: "filter-left-box" }, be = { class: "head-container", style: { "margin-bottom": "0px" } }, ge = { class: "filter-right-box" }, ye = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false } }, emits: ["success"], setup(R, { emit: N }) {
  const U = N, y = R, H = { list: [] }, Q = p(), d = p(), w = p(), r = p({}), v = p(false);
  $("customQuery", O(() => r.value));
  const { form: t, FORM: P } = oe({ title: "制成品申购", defaultForm: H, api: y.isEdit ? V.edit : V.add }, w, y.detail);
  L(() => y.detail, (a = {}) => {
    t.purchaseListObj = {}, t.type = a.type, t.materialType = a.materialType, t.finishedProductType = a.finishedProductType, t.projectId = a.projectId;
  }, { deep: true, immediate: true });
  const { maxHeight: q } = ne({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false, minHeight: 300, extraHeight: 40 });
  X(() => {
    t.list = ue(t.purchaseListObj);
  });
  const A = O(() => {
    switch (t.finishedProductType) {
      case k.STRUC_MANUFACTURED.V:
        return M;
      case k.ENCL_MANUFACTURED.V:
        return pe;
      default:
        return M;
    }
  }), T = O(() => E(t.purchaseListObj) ? Object.keys(t.purchaseListObj).length : 0);
  function F() {
    if (d.value) {
      const a = d.value.selectList;
      if (!(a != null && a.length)) {
        I.warning("请选择数据");
        return;
      }
      for (let e = 0; e < a.length; e++) {
        const s = B(a[e]), o = m(s.curPurchaseQuantity * s.netWeight, 2) || 0;
        g(t.purchaseListObj[s.id]) ? t.purchaseListObj[s.id] = { ...s, curPurchaseWeight: o } : (t.purchaseListObj[s.id].curPurchaseQuantity += s.curPurchaseQuantity, t.purchaseListObj[s.id].curPurchaseWeight = m(t.purchaseListObj[s.id].curPurchaseWeight + o, 2));
      }
      f();
    }
  }
  function D({ id: a, quantity: e }, s) {
    const o = e * s.netWeight || 0;
    t.purchaseListObj[a].curPurchaseQuantity -= e, t.purchaseListObj[a].curPurchaseWeight = m(t.purchaseListObj[a].curPurchaseWeight - o, 2), console.log(t.purchaseListObj[a]), t.purchaseListObj[a].curPurchaseQuantity === 0 && delete t.purchaseListObj[a], f();
  }
  function f() {
    var a;
    (a = d.value) == null || a.refreshList();
  }
  function j() {
    var a;
    (a = d.value) == null || a.refresh();
  }
  L([() => t.projectId, () => r.value.monomerId, () => r.value.areaId], () => {
    r.value.projectId = t.projectId, j();
  }, { immediate: true });
  function z() {
    r.value.monomerId = void 0, r.value.areaId = void 0, r.value.serialNumber = void 0, j();
  }
  async function S() {
    let a = true;
    a = await K(), v.value = a;
  }
  L(() => t.finishedProductType, (a, e) => {
    a && e && (t.list = [], t.purchaseListObj = {});
  }, { immediate: true }), P.HOOK.beforeToEdit = async (a, e) => {
    e.purchaseListObj = {}, e.originListObj = {};
    const s = e.list;
    for (let o = 0; o < s.length; o++) {
      const i = B(s[o]);
      e.originListObj[i.id] = i;
      const h = m(i.quantity * i.netWeight, 2) || 0;
      g(e.purchaseListObj[i.id]) ? e.purchaseListObj[i.id] = { ...i, curPurchaseQuantity: i.quantity, curPurchaseWeight: h } : (e.purchaseListObj[i.id].curPurchaseQuantity += i.quantity, e.purchaseListObj[i.id].curPurchaseWeight = m(e.purchaseListObj[i.id].curPurchaseWeight + h, 2));
    }
    Z(() => {
      j();
    });
  }, P.HOOK.afterSubmit = () => {
    U("success");
  };
  function K() {
    return g(t.projectId) ? (I.warning("请选择项目"), false) : g(t.list) ? (I.warning("请选择数据"), false) : true;
  }
  return (a, e) => {
    const s = ae, o = G("common-button"), i = se, h = ie;
    return x(), J("div", fe, [n(de, { ref_key: "commonWrapperRef", ref: Q, "show-footer": false }, { default: l(() => [_("div", he, [_("div", _e, [_("div", be, [c(E)(c(t).projectId) ? (x(), W(c(le), { key: 0, monomerId: r.value.monomerId, "onUpdate:monomerId": e[0] || (e[0] = (u) => r.value.monomerId = u), areaId: r.value.areaId, "onUpdate:areaId": e[1] || (e[1] = (u) => r.value.areaId = u), areaType: c(ce).OUTSOURCE.V, clearable: "", areaClearable: "", "project-id": c(t).projectId }, null, 8, ["monomerId", "areaId", "areaType", "project-id"])) : Y("", true), n(s, { modelValue: r.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (u) => r.value.serialNumber = u), modelModifiers: { trim: true }, placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: ee(f, ["enter"]) }, null, 8, ["modelValue"]), n(o, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: C(f, ["stop"]) }, { default: l(() => e[4] || (e[4] = [b(" 搜索 ")])), _: 1, __: [4] }), n(o, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: C(z, ["stop"]) }, { default: l(() => e[5] || (e[5] = [b(" 重置 ")])), _: 1, __: [5] })])]), _("div", ge, [n(o, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-plus", onClick: F }, { default: l(() => e[6] || (e[6] = [b(" 选择加入 ")])), _: 1, __: [6] }), n(i, { value: T.value, max: 99, hidden: T.value < 1, style: { "margin-right": "10px" } }, { default: l(() => [n(o, { class: "filter-item", size: "default", type: "success", icon: "el-icon-shopping-cart-2", onClick: S }, { default: l(() => e[7] || (e[7] = [b(" 申购车 ")])), _: 1, __: [7] })]), _: 1 }, 8, ["value", "hidden"])])]), n(h, { ref_key: "formRef", ref: w, model: c(t) }, { default: l(() => [(x(), W(te(A.value), { ref_key: "tableRef", ref: d, "max-height": c(q) }, null, 8, ["max-height"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 512), n(me, { modelValue: v.value, "onUpdate:modelValue": e[3] || (e[3] = (u) => v.value = u), "is-manufactured": "", onManufDel: D }, null, 8, ["modelValue"])]);
  };
} }, Te = re(ye, [["__scopeId", "data-v-f0e4324a"]]);
export {
  Te as default
};
