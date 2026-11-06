import { watch as Y } from "vue";
import { ref as h } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as g } from "vue";
import { createBlock as v } from "vue";
import { withCtx as n } from "vue";
import { unref as p } from "vue";
import { createCommentVNode as D } from "vue";
import { withDirectives as I } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as k } from "vue";
import { vShow as M } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as f } from "vue";
import { createElementBlock as Z } from "vue";
import { isRef as ee } from "vue";
import { ElNotification as te } from "element-plus";
import { nextTick as ae } from "vue";
import { ElPopconfirm as le } from "element-plus";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElDescriptions as oe } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { vLoading as se } from "element-plus";
import { d as ce, a as re, _ as ue, c as de } from "./issue-record-form.vue.js";
import { u as me, o as pe, G as fe, z as be, p as q, aw as ye } from "../../../../../shared/runtime.js";
import "../../../../../modules/PicUpload-8580ccfc.js";
const ge = { class: "head-container" }, he = { key: 1 }, Ce = { __name: "delivery-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: "" } }, emits: ["update:modelValue", "success"], setup(o, { emit: B }) {
  const x = B, u = o, { visible: w, handleClose: j } = me({ emit: x, props: u });
  Y(w, (t) => {
    t && F();
  });
  const P = h(), R = h([]), b = h([]), L = h(), C = h(false), T = h(false), { maxHeight: E } = pe({ mainBox: ".delivery-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, L), S = { selectQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }] }, { tableValidate: N, wrongCellMask: U } = ye({ rules: S });
  function z(t, l) {
    t.selectQuantity = l, t.actualMete = (t.selectQuantity * (t.accountingMete / t.quantity)).toFixed(3);
  }
  function H(t) {
    b.value = t || [];
  }
  async function F() {
    var l, y;
    let t = [];
    C.value = true;
    try {
      const { content: r = [] } = u.showType === "detail" ? await ce((l = u.detailInfo) == null ? void 0 : l.id, { projectId: u.globalProject.id }) : await re((y = u.detailInfo) == null ? void 0 : y.id, { projectId: u.globalProject.id });
      r.map((i) => {
        var d, m;
        i.monomerName = (d = i.monomer) == null ? void 0 : d.name, i.areaName = (m = i.area) == null ? void 0 : m.name, i.selectQuantity = i.quantity, i.actualMete = i.accountingMete;
      }), t = r;
    } catch (r) {
      console.log("收货明细", r);
    } finally {
      R.value = t, C.value = false;
    }
  }
  async function O(t) {
    var y, r;
    const { validResult: l } = N(b.value);
    if (l) try {
      const i = (y = b.value) == null ? void 0 : y.map((m) => ({ linkId: m.linkId, productType: m.productType, quantity: m.selectQuantity })), d = { boolProblemReceiving: t, cargoListId: (r = u.detailInfo) == null ? void 0 : r.id, projectId: u.globalProject.id, receiveProductDTOParam: i };
      await de.edit(d), te({ title: "提交成功", type: "success" }), x("success"), j();
    } catch (i) {
      console.log("审核", i);
    }
  }
  async function A(t) {
    ae(async () => {
      await P.value.toggleRowSelection(t, false);
    });
  }
  function $() {
    const { validResult: t } = N(b.value);
    t && (T.value = true);
  }
  function G() {
    x("success"), j();
  }
  return (t, l) => {
    const y = _("print-table"), r = _("common-button"), i = le, d = ne, m = oe, c = ie, J = _("table-cell-tag"), K = _("common-input-number"), W = _("common-table"), X = _("common-drawer"), Q = se;
    return g(), v(X, { ref_key: "drawerRef", ref: L, title: "发货明细", "close-on-click-modal": false, modelValue: p(w), "onUpdate:modelValue": l[2] || (l[2] = (e) => ee(w) ? w.value = e : null), direction: "rtl", "before-close": p(j), "custom-class": "delivery-detail", size: "80%" }, { titleAfter: n(() => {
      var e;
      return [p(fe)(o.permission.print) ? (g(), v(y, { key: 0, "api-key": o.showType === "edit" ? "deliveryPartCargoList" : "deliveryCargoList", params: { cargoListId: (e = u.detailInfo) == null ? void 0 : e.id, projectId: o.globalProject.id }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])) : D("", true)];
    }), titleRight: n(() => {
      var e;
      return [I(a(r, { type: "danger", disabled: !((e = b.value) != null && e.length), size: "default", onClick: $ }, { default: n(() => l[3] || (l[3] = [k(" 记录问题 ")])), _: 1, __: [3] }, 8, ["disabled"]), [[M, o.showType === "edit"]]), a(i, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "#626AEF", title: "确定收货吗?", onConfirm: l[0] || (l[0] = (s) => O(0)) }, { reference: n(() => {
        var s;
        return [I(a(r, { type: "success", disabled: !((s = b.value) != null && s.length), size: "default" }, { default: n(() => l[4] || (l[4] = [k("确定收货")])), _: 1, __: [4] }, 8, ["disabled"]), [[M, o.showType === "edit"]])];
      }), _: 1 })];
    }), content: n(() => [V("div", ge, [I((g(), v(m, { column: 2, border: "" }, { default: n(() => [a(d, { align: "center", "label-class-name": "contractLabel", label: "项目" }, { default: n(() => [k(f(p(be)(o.detailInfo.project)), 1)]), _: 1 }), a(d, { align: "center", "label-class-name": "contractLabel", label: "发运日期" }, { default: n(() => [k(f(p(q)(o.detailInfo.auditTime, "{y}-{m}-{d}")), 1)]), _: 1 }), a(d, { align: "center", "label-class-name": "contractLabel", label: "收货人" }, { default: n(() => [k(f(o.detailInfo.auditReceiptName || "-"), 1)]), _: 1 }), a(d, { align: "center", "label-class-name": "contractLabel", label: "收货日期" }, { default: n(() => [k(f(p(q)(o.detailInfo.auditReceiptTime, "{y}-{m}-{d}") || "-"), 1)]), _: 1 })]), _: 1 })), [[Q, C.value]])]), I((g(), v(W, { ref_key: "tableRef", ref: P, data: R.value, "max-height": p(E), "return-source-data": "", "cell-class-name": p(U), onSelectionChange: H }, { default: n(() => [o.showType === "edit" ? (g(), v(c, { key: 0, type: "selection", align: "center", width: "60" })) : D("", true), a(c, { label: "序号", type: "index", align: "center", width: "60" }), a(c, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: n(({ row: e }) => {
      var s;
      return [V("span", null, f(((s = e.monomer) == null ? void 0 : s.name) || "-"), 1)];
    }), _: 1 }), a(c, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: n(({ row: e }) => {
      var s;
      return [V("span", null, f(((s = e.area) == null ? void 0 : s.name) || "-"), 1)];
    }), _: 1 }), a(c, { key: "name", prop: "name", label: "名称", align: "center" }, { default: n(({ row: e }) => [a(J, { show: e.boolProblemReceiving, name: "问题收货", color: "#f56c6c" }, null, 8, ["show"]), V("span", null, f(e.name), 1)]), _: 1 }), a(c, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), a(c, { key: "specification", prop: "specification", label: "规格", align: "center" }), a(c, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }), a(c, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center" }, { default: n(({ row: e }) => [o.showType === "edit" ? (g(), v(K, { key: 0, modelValue: e.selectQuantity, "onUpdate:modelValue": (s) => e.selectQuantity = s, controls: false, min: 0, max: e.quantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (s) => z(e, s) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])) : (g(), Z("span", he, f(e.quantity), 1))]), _: 1 }), a(c, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), a(c, { key: "actualMete", prop: "actualMete", label: "核算量", align: "center" })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[Q, C.value]]), a(ue, { modelValue: T.value, "onUpdate:modelValue": l[1] || (l[1] = (e) => T.value = e), "detail-info": o.detailInfo, selections: b.value, permission: o.permission, globalProject: o.globalProject, onDelChange: A, onSuccess: G }, null, 8, ["modelValue", "detail-info", "selections", "permission", "globalProject"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Ce as default
};
