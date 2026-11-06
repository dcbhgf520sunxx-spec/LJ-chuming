import { useStore as re } from "vuex";
import { computed as N } from "vue";
import { ref as g } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as T } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as se } from "vue";
import { unref as r } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as m } from "vue";
import { createElementBlock as w } from "vue";
import { createCommentVNode as ne } from "vue";
import { withModifiers as ie } from "vue";
import { ElMessage as S } from "element-plus";
import { ElFormItem as ue } from "element-plus";
import { ElCol as de } from "element-plus";
import { ElRow as ce } from "element-plus";
import { ElForm as pe } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElInputNumber as fe } from "element-plus";
import { _ as _e, u as we, ao as ye, p6 as P, qh as be, qi as ge, qj as he, i as ve, aV as ke, fa as Ie, bV as F, aw as qe, qk as Ne } from "../../../../../../shared/runtime.js";
import { u as Pe } from "../../../../../../modules/use-production-team-d8043fd6.js";
import { _ as Ve } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const xe = { class: "form-grop" }, Ee = { key: 0 }, Ce = { key: 1 }, Te = { key: 0, style: { color: "red" } }, Ae = { key: 0 }, Re = { key: 1 }, Le = { key: 0 }, Be = { key: 1 }, Se = { __name: "initiate-approval", props: { visible: { type: Boolean, default: false }, addList: { type: Array, default: () => [] }, addQuantity: { type: [Number, String], default: 0 }, addNetWeight: { type: [Number, String], default: 0 }, query: { type: Object, default: () => {
} }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["update:visible", "removeRow", "success"], setup(y, { emit: M }) {
  const j = re(), { productionTeam: W } = Pe(), U = N(() => W.value.filter((s) => b.query.typeEnum === s.productType && i.workshopId === s.workshopId && i.processId === s.processId)), V = M, v = y, D = g(false), x = g(false), u = g([]), { visible: $, handleClose: A } = we({ emit: V, props: v, field: "visible", showHook: z, closeHook: O }), H = g({ workshopId: void 0, processId: void 0 }), E = g(), { crud: b, form: i } = ye(H, E);
  function z() {
    C();
  }
  function O() {
  }
  const R = N(() => {
    let s = 0;
    return u.value.length && (s = u.value.reduce((a, n) => {
      const l = Number(n.quotaPrice);
      return isNaN(l) ? a : a + l;
    }, 0)), s;
  }), L = N(() => {
    let s = 0;
    return s = u.value.reduce((a, n) => {
      const l = Number(n.newPrice);
      return isNaN(l) ? a : a + l;
    }, 0), s;
  }), Q = { newPrice: [{ validator: (s, a) => !(a.quotaNumber && !s), message: "请输入新工价", trigger: "change" }] }, G = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }] }, J = /* @__PURE__ */ new Map([]), { tableValidate: K, wrongCellMask: X } = qe({ rules: Q, ditto: J });
  function Y(s) {
    if (u.value.length) {
      const a = u.value.findIndex((n) => n.id === s.id);
      a > -1 && u.value.splice(a, 1);
    }
    V("removeRow", s);
  }
  const Z = N(() => {
    switch (v.query.typeEnum) {
      case P.ARTIFACT.V:
        return he;
      case P.ASSEMBLE.V:
        return ge;
      case P.MACHINE_PART.V:
        return be;
      default:
        return "";
    }
  });
  async function C() {
    const s = v.addList ? v.addList.map((n) => n.id) : [], a = { processId: i.processId, workshopId: i.workshopId };
    if (!(!i.workshopId || !i.processId)) try {
      let { content: n } = await Z.value(s, a);
      n.length && (n = n.map((l) => {
        var d, f, k, I, c;
        return l.serialNumber = ((d = l.product) == null ? void 0 : d.serialNumber) || void 0, l.specification = ((f = l.product) == null ? void 0 : f.specification) || void 0, l.quantity = ((k = l.product) == null ? void 0 : k.quantity) || void 0, l.newPrice = ((I = l.product) == null ? void 0 : I.newPrice) || void 0, l.productSerialNumber = (c = l.product) == null ? void 0 : c.serialNumber, l;
      })), u.value = n || [];
    } catch (n) {
      console.log(n);
    }
  }
  async function ee() {
    if (!await E.value.validate()) return;
    const { validResult: a, dealList: n } = K(u.value);
    if (a) u.value = n;
    else return a;
    let l = false;
    if (u.value.length && u.value.forEach((f) => {
      f.quotaNumber || (l = true);
    }), l) {
      S({ message: "有未配置定额的数据，无法提交！", type: "error" });
      return;
    }
    const d = { projectId: b.query.projectId, monomerId: b.query.monomerId, productTypeEnum: b.query.typeEnum, workshopId: i.workshopId, processId: i.processId, teamIdList: i.teamIds, quotaPrice: R.value, adjustPrice: L.value, floatPrice: L.value - R.value, productList: u.value };
    try {
      x.value = true, await Ne(d), V("success"), S({ message: "发起审批成功！", type: "success" }), await j.dispatch("approval_list/fetchApprovalNum"), A();
    } catch (f) {
      console.log(f);
    } finally {
      x.value = false;
    }
  }
  return (s, a) => {
    var B;
    const n = h("common-button"), l = ue, d = de, f = ce, k = h("common-select"), I = pe, c = me, te = h("table-cell-tag"), oe = fe, ae = h("common-table"), le = h("common-drawer");
    return _(), T(le, { "append-to-body": "", ref_key: "drawerRef", ref: D, visible: r($), title: `${r(P).VL[(B = y.query) == null ? void 0 : B.typeEnum]}工价调整`, "before-close": r(A), size: "50%" }, { titleRight: t(() => [e(n, { loading: x.value, size: "default", type: "success", onClick: ee }, { default: t(() => a[3] || (a[3] = [se(" 发起审批 ")])), _: 1, __: [3] }, 8, ["loading"])]), content: t(() => [e(I, { ref_key: "formRef", ref: E, model: r(i), rules: G }, { default: t(() => [p("div", xe, [e(f, null, { default: t(() => [e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "项目", prop: "phone" }, { default: t(() => a[4] || (a[4] = [p("span", null, m("项目"), -1)])), _: 1, __: [4] })]), _: 1 }), e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "单体", prop: "username" }, { default: t(() => [p("span", null, m(r(b).query.monomerName), 1)]), _: 1 })]), _: 1 })]), _: 1 }), e(f, null, { default: t(() => [e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "数量", prop: "dept" }, { default: t(() => [p("span", null, m(y.addQuantity), 1)]), _: 1 })]), _: 1 }), e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "重量", prop: "jobId" }, { default: t(() => [r(ve)(y.addNetWeight) ? (_(), w("span", Ee, m(y.addNetWeight.toFixed(3)) + " kg", 1)) : (_(), w("span", Ce, "-"))]), _: 1 })]), _: 1 })]), _: 1 }), e(f, null, { default: t(() => [e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "工序", prop: "processId" }, { default: t(() => {
      var o;
      return [e(r(Ve), { modelValue: r(i).processId, "onUpdate:modelValue": a[0] || (a[0] = (q) => r(i).processId = q), class: "filter-item", multiple: false, "product-type": (o = y.query) == null ? void 0 : o.typeEnum, clearable: "", placeholder: "请选择工序", onChange: C }, null, 8, ["modelValue", "product-type"])];
    }), _: 1 })]), _: 1 }), e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "车间", prop: "workshopId" }, { default: t(() => [e(r(ke), { modelValue: r(i).workshopId, "onUpdate:modelValue": a[1] || (a[1] = (o) => r(i).workshopId = o), placeholder: "请选择车间", "workshop-type": r(Ie).BUILDING.V, "factory-id": r(b).query.factoryId, class: "filter-item", clearable: "", onChange: C }, null, 8, ["modelValue", "workshop-type", "factory-id"])]), _: 1 })]), _: 1 })]), _: 1 }), e(f, null, { default: t(() => [e(d, { span: 12 }, { default: t(() => [e(l, { class: "form-item", label: "班组", prop: "teamIds" }, { default: t(() => [e(k, { modelValue: r(i).teamIds, "onUpdate:modelValue": a[2] || (a[2] = (o) => r(i).teamIds = o), options: U.value, type: "other", "collapse-tags": "", multiple: "", filterable: "", clearable: "", dataStructure: { key: "id", label: "label", value: "id" }, placeholder: "全部班组", style: { width: "100%" } }, { empty: t(() => a[5] || (a[5] = [p("div", { style: { "text-align": "center", display: "flex", "flex-direction": "column", padding: "10px", color: "#c0c4cc" } }, [p("span", null, "暂无数据"), p("span", { style: { "margin-top": "5px", color: "#f56c6c" } }, "*请到班组管理进行配置")], -1)])), _: 1 }, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), e(d, { span: 12 }, { default: t(() => a[6] || (a[6] = [p("div", { style: { width: "100%", height: "100%", "border-top": "1px solid #dcdfe6", "border-left": "1px solid #dcdfe6" } }, null, -1)])), _: 1, __: [6] })]), _: 1 })])]), _: 1 }, 8, ["model"]), !r(i).workshopId || !r(i).processId ? (_(), w("div", Te, "*请先选择工序和车间")) : (_(), T(ae, { key: 1, ref: "tableRef", data: u.value, "empty-text": "暂无数据", "max-height": s.maxHeight, "return-source-data": "", "cell-class-name": r(X), showEmptySymbol: false, style: { width: "100%" } }, { default: t(() => [e(c, { label: "序号", type: "index", align: "center", width: "60" }), e(c, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: t((o) => [o.row.quotaNumber ? ne("", true) : (_(), T(te, { key: 0, name: "未配置定额", color: "#e64242", offset: 15 })), p("span", null, m(o.row.serialNumber || "-"), 1)]), _: 1 }), e(c, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: t((o) => [p("span", null, m(o.row.specification || "-"), 1)]), _: 1 }), e(c, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: t((o) => [p("span", null, m(o.row.quantity ?? "-"), 1)]), _: 1 }), e(c, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": "", label: "执行定额", align: "center" }, { default: t((o) => [p("span", null, m(o.row.quotaNumber || "-"), 1)]), _: 1 }), e(c, { key: "quotaPrice", prop: "quotaPrice", "show-overflow-tooltip": "", label: "定额工价", align: "center", width: "140px" }, { default: t((o) => [o.row.quotaPrice || o.row.quotaPrice === 0 ? (_(), w("span", Ae, m(r(F)(o.row.quotaPrice, 2)) + " 元/" + m(o.row.unit || "?"), 1)) : (_(), w("span", Re, "-"))]), _: 1 }), e(c, { key: "newPrice", prop: "newPrice", "show-overflow-tooltip": "", label: "新工价(元)", align: "center", width: "180px" }, { default: t((o) => [e(oe, { modelValue: o.row.newPrice, "onUpdate:modelValue": (q) => o.row.newPrice = q, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: 2, disabled: !o.row.quotaNumber, placeholder: "输入新工价", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), e(c, { key: "float", prop: "float", "show-overflow-tooltip": "", label: "浮动", align: "center", width: "120px" }, { default: t((o) => [o.row.newPrice && o.row.quotaPrice ? (_(), w("span", Le, m(r(F)(o.row.newPrice - o.row.quotaPrice, 2)) + " 元/" + m(o.row.unit || "?"), 1)) : (_(), w("span", Be, "-"))]), _: 1 }), e(c, { label: "操作", align: "center", fixed: "right" }, { default: t((o) => [e(n, { type: "danger", icon: "el-icon-delete", onClick: ie((q) => Y(o.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]))]), _: 1 }, 8, ["visible", "title", "before-close"]);
  };
} }, He = _e(Se, [["__scopeId", "data-v-63b7b47c"]]);
export {
  He as default
};
