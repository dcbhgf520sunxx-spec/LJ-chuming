import { useStore as ne } from "vuex";
import { computed as q } from "vue";
import { ref as h } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as c } from "vue";
import { createBlock as T } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as ie } from "vue";
import { unref as l } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as d } from "vue";
import { createElementBlock as g } from "vue";
import { createCommentVNode as se } from "vue";
import { withModifiers as de } from "vue";
import { ElMessage as M } from "element-plus";
import { ElFormItem as ue } from "element-plus";
import { ElCol as ce } from "element-plus";
import { ElRow as pe } from "element-plus";
import { ElForm as me } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElInputNumber as we } from "element-plus";
import { _ as ge, u as _e, ao as ye, p6 as V, qh as be, qi as he, qj as Ie, i as ve, aV as ke, fa as Pe, bV as z, aw as Ne, qk as qe } from "../../../../../../shared/runtime.js";
import { u as Ve } from "../../../../../../modules/use-production-team-d8043fd6.js";
import { _ as ze } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const Oe = { class: "form-grop" }, xe = { key: 0 }, Ee = { key: 1 }, Ce = { key: 0, style: { color: "red" } }, Te = { key: 0 }, Ae = { key: 1 }, Re = { key: 0 }, Le = { key: 1 }, Be = { key: 0 }, Se = { key: 1 }, je = { key: 0 }, Me = { key: 1 }, Fe = { __name: "initiate-approval", props: { visible: { type: Boolean, default: false }, addList: { type: Array, default: () => [] }, addQuantity: { type: [Number, String], default: 0 }, addNetWeight: { type: [Number, String], default: 0 }, query: { type: Object, default: () => {
} }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["update:visible", "removeRow", "success"], setup(y, { emit: F }) {
  const U = ne(), { productionTeam: W } = Ve(), D = q(() => W.value.filter((n) => _.query.typeEnum === n.productType && s.workshopId === n.workshopId && s.processId === n.processId)), O = F, v = y, $ = h(false), x = h(false), p = h([]), { visible: H, handleClose: A } = _e({ emit: O, props: v, field: "visible", showHook: G, closeHook: J }), Q = h({ workshopId: void 0, processId: void 0 }), E = h(), { crud: _, form: s } = ye(Q, E);
  function G() {
    C();
  }
  function J() {
  }
  const R = q(() => {
    let n = 0;
    return p.value.length && (n = p.value.reduce((r, i) => {
      const a = Number(i.quotaPrice);
      return isNaN(a) ? r : r + a;
    }, 0)), n;
  }), L = q(() => {
    let n = 0;
    return n = p.value.reduce((r, i) => {
      const a = Number(i.newPrice);
      return isNaN(a) ? r : r + a;
    }, 0), n;
  }), B = (n, r) => !(r.quotaNumber && !n), K = { newOrganizationInsidePrice: [{ validator: B, message: "请输入编制内新工价", trigger: "change" }], newOrganizationOutsidePrice: [{ validator: B, message: "请输入编制外新工价", trigger: "change" }] }, X = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }] }, Y = /* @__PURE__ */ new Map([]), { tableValidate: Z, wrongCellMask: ee } = Ne({ rules: K, ditto: Y });
  function te(n) {
    if (p.value.length) {
      const r = p.value.findIndex((i) => i.productId === n.productId);
      r > -1 && p.value.splice(r, 1);
    }
    O("removeRow", n);
  }
  const oe = q(() => {
    switch (v.query.typeEnum) {
      case V.ARTIFACT.V:
        return Ie;
      case V.ASSEMBLE.V:
        return he;
      case V.MACHINE_PART.V:
        return be;
      default:
        return "";
    }
  });
  async function C() {
    const n = v.addList ? v.addList.map((i) => i.id) : [], r = { processId: s.processId, workshopId: s.workshopId };
    if (!(!s.workshopId || !s.processId)) try {
      let { content: i } = await oe.value(n, r);
      i.length && (i = i.map((a) => {
        var m, w, k, P, u, N;
        return a.productId = ((m = a.product) == null ? void 0 : m.id) || void 0, a.serialNumber = ((w = a.product) == null ? void 0 : w.serialNumber) || void 0, a.specification = ((k = a.product) == null ? void 0 : k.specification) || void 0, a.quantity = ((P = a.product) == null ? void 0 : P.quantity) || void 0, a.newPrice = ((u = a.product) == null ? void 0 : u.newPrice) || void 0, a.productSerialNumber = (N = a.product) == null ? void 0 : N.serialNumber, a;
      })), p.value = i || [];
    } catch (i) {
      console.log(i);
    }
  }
  async function ae() {
    if (!await E.value.validate()) return;
    const { validResult: r, dealList: i } = Z(p.value);
    if (r) p.value = i;
    else return r;
    let a = false;
    if (p.value.length && p.value.forEach((w) => {
      w.quotaNumber || (a = true);
    }), a) {
      M({ message: "有未配置定额的数据，无法提交！", type: "error" });
      return;
    }
    const m = { projectId: _.query.projectId, monomerId: _.query.monomerId, productTypeEnum: _.query.typeEnum, workshopId: s.workshopId, processId: s.processId, teamIdList: s.teamIds, quotaPrice: R.value, adjustPrice: L.value, floatPrice: L.value - R.value, productList: p.value };
    try {
      x.value = true, await qe(m), O("success"), M({ message: "发起审批成功！", type: "success" }), await U.dispatch("approval_list/fetchApprovalNum"), A();
    } catch (w) {
      console.log(w);
    } finally {
      x.value = false;
    }
  }
  return (n, r) => {
    var j;
    const i = I("common-button"), a = ue, m = ce, w = pe, k = I("common-select"), P = me, u = fe, N = I("table-cell-tag"), S = we, re = I("common-table"), le = I("common-drawer");
    return c(), T(le, { "append-to-body": "", ref_key: "drawerRef", ref: $, visible: l(H), title: `${l(V).VL[(j = y.query) == null ? void 0 : j.typeEnum]}工价调整`, "before-close": l(A), size: "70%", "custom-class": "wage-modification-initiate-approval" }, { titleRight: o(() => [t(i, { loading: x.value, size: "default", type: "success", onClick: ae }, { default: o(() => r[3] || (r[3] = [ie(" 发起审批 ")])), _: 1, __: [3] }, 8, ["loading"])]), content: o(() => [t(P, { ref_key: "formRef", ref: E, model: l(s), rules: X }, { default: o(() => [f("div", Oe, [t(w, null, { default: o(() => [t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "项目", prop: "phone" }, { default: o(() => [f("span", null, d(l(_).query.projectSerialNumber) + " - " + d(l(_).query.projectName), 1)]), _: 1 })]), _: 1 }), t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "单体", prop: "username" }, { default: o(() => [f("span", null, d(l(_).query.monomerName), 1)]), _: 1 })]), _: 1 })]), _: 1 }), t(w, null, { default: o(() => [t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "总数量", prop: "dept" }, { default: o(() => [f("span", null, d(y.addQuantity), 1)]), _: 1 })]), _: 1 }), t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "总重量", prop: "jobId" }, { default: o(() => [l(ve)(y.addNetWeight) ? (c(), g("span", xe, d(y.addNetWeight.toFixed(3)) + " kg", 1)) : (c(), g("span", Ee, "-"))]), _: 1 })]), _: 1 })]), _: 1 }), t(w, null, { default: o(() => [t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "工序", prop: "processId" }, { default: o(() => {
      var e;
      return [t(l(ze), { modelValue: l(s).processId, "onUpdate:modelValue": r[0] || (r[0] = (b) => l(s).processId = b), class: "filter-item", multiple: false, "product-type": (e = y.query) == null ? void 0 : e.typeEnum, clearable: "", placeholder: "请选择工序", onChange: C }, null, 8, ["modelValue", "product-type"])];
    }), _: 1 })]), _: 1 }), t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "车间", prop: "workshopId" }, { default: o(() => [t(l(ke), { modelValue: l(s).workshopId, "onUpdate:modelValue": r[1] || (r[1] = (e) => l(s).workshopId = e), placeholder: "请选择车间", "workshop-type": l(Pe).BUILDING.V, "factory-id": l(_).query.factoryId, class: "filter-item", clearable: "", onChange: C }, null, 8, ["modelValue", "workshop-type", "factory-id"])]), _: 1 })]), _: 1 })]), _: 1 }), t(w, null, { default: o(() => [t(m, { span: 12 }, { default: o(() => [t(a, { class: "form-item", label: "班组", prop: "teamIds" }, { default: o(() => [t(k, { modelValue: l(s).teamIds, "onUpdate:modelValue": r[2] || (r[2] = (e) => l(s).teamIds = e), options: D.value, type: "other", "collapse-tags": "", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "全部班组", style: { width: "100%" } }, { empty: o(() => r[4] || (r[4] = [f("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [f("span", null, "暂无数据"), f("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), t(m, { span: 12 }, { default: o(() => r[5] || (r[5] = [f("div", { style: { width: "100%", height: "100%", "border-top": "1px solid #dcdfe6", "border-left": "1px solid #dcdfe6" } }, null, -1)])), _: 1, __: [5] })]), _: 1 })])]), _: 1 }, 8, ["model"]), !l(s).workshopId || !l(s).processId ? (c(), g("div", Ce, "*请先选择工序和车间")) : (c(), T(re, { key: 1, ref: "tableRef", data: p.value, "empty-text": "暂无数据", "max-height": n.maxHeight, "return-source-data": "", "cell-class-name": l(ee), showEmptySymbol: false, style: { width: "100%" } }, { default: o(() => [t(u, { label: "序号", type: "index", align: "center", width: "60" }), t(u, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", "min-width": "120" }, { default: o((e) => [e.row.quotaNumber ? se("", true) : (c(), T(N, { key: 0, name: "未配置定额", color: "#e64242", offset: 15 })), f("span", null, d(e.row.serialNumber || "-"), 1)]), _: 1 }), t(u, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "120" }, { default: o((e) => [f("span", null, d(e.row.specification || "-"), 1)]), _: 1 }), t(u, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", width: "80" }, { default: o((e) => [f("span", null, d(e.row.quantity ?? "-"), 1)]), _: 1 }), t(u, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": "", label: "执行定额", align: "center" }, { default: o((e) => [f("span", null, d(e.row.quotaNumber || "-"), 1)]), _: 1 }), t(u, { key: "organizationInsidePrice", prop: "organizationInsidePrice", "show-overflow-tooltip": "", label: "编制内单价", align: "center" }, { default: o((e) => [e.row.organizationInsidePrice || e.row.organizationInsidePrice === 0 ? (c(), g("span", Te, d(l(z)(e.row.organizationInsidePrice, 2)) + " 元/" + d(e.row.unit || "?"), 1)) : (c(), g("span", Ae, "-"))]), _: 1 }), t(u, { key: "organizationOutsidePrice", prop: "organizationOutsidePrice", "show-overflow-tooltip": "", label: "编制外单价", align: "center" }, { default: o((e) => [e.row.organizationOutsidePrice || e.row.organizationOutsidePrice === 0 ? (c(), g("span", Re, d(l(z)(e.row.organizationOutsidePrice, 2)) + " 元/" + d(e.row.unit || "?"), 1)) : (c(), g("span", Le, "-"))]), _: 1 }), t(u, { key: "newOrganizationInsidePrice", prop: "newOrganizationInsidePrice", "show-overflow-tooltip": "", label: "编制内新工价(元)", align: "center", width: "120px" }, { default: o((e) => [t(S, { modelValue: e.row.newOrganizationInsidePrice, "onUpdate:modelValue": (b) => e.row.newOrganizationInsidePrice = b, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: 2, disabled: !e.row.quotaNumber, placeholder: "输入", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), t(u, { key: "newOrganizationOutsidePrice", prop: "newOrganizationOutsidePrice", "show-overflow-tooltip": "", label: "编制外新工价(元)", align: "center", width: "120px" }, { default: o((e) => [t(S, { modelValue: e.row.newOrganizationOutsidePrice, "onUpdate:modelValue": (b) => e.row.newOrganizationOutsidePrice = b, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: 2, disabled: !e.row.quotaNumber, placeholder: "输入", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), t(u, { key: "float", prop: "float", "show-overflow-tooltip": "", label: "编制内浮动", align: "center", width: "120px" }, { default: o((e) => [e.row.newOrganizationInsidePrice && e.row.organizationInsidePrice ? (c(), g("span", Be, d(l(z)(e.row.newOrganizationInsidePrice - e.row.organizationInsidePrice, 2)) + " 元/" + d(e.row.unit || "?"), 1)) : (c(), g("span", Se, "-"))]), _: 1 }), t(u, { key: "float", prop: "float", "show-overflow-tooltip": "", label: "编制外浮动", align: "center", width: "120px" }, { default: o((e) => [e.row.newOrganizationOutsidePrice && e.row.organizationOutsidePrice ? (c(), g("span", je, d(l(z)(e.row.newOrganizationOutsidePrice - e.row.organizationOutsidePrice, 2)) + " 元/" + d(e.row.unit || "?"), 1)) : (c(), g("span", Me, "-"))]), _: 1 }), t(u, { label: "操作", align: "center", fixed: "right", width: "100" }, { default: o((e) => [t(i, { type: "danger", icon: "el-icon-delete", onClick: de((b) => te(e.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]))]), _: 1 }, 8, ["visible", "title", "before-close"]);
  };
} }, Ge = ge(Fe, [["__scopeId", "data-v-ee1a58a4"]]);
export {
  Ge as default
};
