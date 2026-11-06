import { ref as h } from "vue";
import { watch as X } from "vue";
import { nextTick as Y } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as f } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as a } from "vue";
import { normalizeClass as T } from "vue";
import { withDirectives as B } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as D } from "vue";
import { isRef as $ } from "vue";
import { ElNotification as ee } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElDivider as te } from "element-plus";
import { ElFormItem as ae } from "element-plus";
import { ElInputNumber as ie } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElForm as re } from "element-plus";
import { g as se, c as de } from "../../../../../modules/logistics-list-3b33cbe0.js";
import { _ as ue, t as ce, u as pe, o as fe, bC as me, bx as ye, bz as ge, z as ve, c as be, D as he, bB as u, bs as w } from "../../../../../shared/runtime.js";
const Te = { style: { display: "flex" }, class: "detail-header" }, _e = { style: { flex: "1", "padding-right": "8px" } }, we = { class: "project-name" }, xe = { style: { "margin-right": "3px" } }, Ie = { style: { "margin-right": "3px" } }, Ve = { key: 0, style: { flex: "1", "padding-left": "8px" } }, Ee = { style: { "margin-right": "3px" } }, ke = { style: { "margin-right": "3px" } }, Ce = { style: { "margin-right": "3px" } }, Ne = { __name: "form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: "detail" }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: H }) {
  const { decimalPrecision: v } = ce(), p = t, g = h(), F = h(), k = h(), C = h(false), P = h([]), o = h(JSON.parse(JSON.stringify({ id: void 0, price: void 0, priceType: void 0, remark: void 0 }))), U = { price: { required: true, validator: (c, i, _) => {
    var I;
    i ? o.value.priceType === p.detailInfo.priceType && i === ((I = p.detailInfo.supplier) == null ? void 0 : I.price) && _(new Error("价格未变动")) : _(new Error("必填且大于0")), _();
  }, trigger: "blur" }, priceType: { required: true, message: "请选择计价方式", trigger: "change" } }, R = H, { visible: x, handleClose: W } = pe({ emit: R, props: p }), { maxHeight: S } = fe({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 120 }, () => F.value.loaded);
  X(() => x.value, (c) => {
    c && (p.showType === "edit" ? L() : G());
  }, { deep: true, immediate: true });
  async function G() {
    try {
      P.value = await se(p.detailInfo.id) || [];
    } catch (c) {
      console.log("获取价格变更记录", c);
    }
  }
  function L() {
    var c;
    g.value && g.value.resetFields(), o.value.id = p.detailInfo.id, o.value.price = (c = p.detailInfo.supplier) == null ? void 0 : c.price, o.value.priceType = p.detailInfo.priceType, o.value.remark = void 0, k.value = p.detailInfo.totalPrice, g.value && Y(() => {
      g.value.clearValidate();
    }), me(g, o);
  }
  function j() {
    k.value = o.value.priceType === u.WEIGHT.V ? p.detailInfo.actualWeight * o.value.price / 1e3 : void 0;
  }
  async function M() {
    C.value = true;
    try {
      if (!await g.value.validate()) return;
      await de.edit(o.value.id, o.value), ee({ title: "修改成功", type: "success" }), R("success"), W();
    } catch (c) {
      console.log("价格修改失败", c);
    } finally {
      C.value = false;
    }
  }
  return (c, i) => {
    const _ = le, I = V("common-button"), N = te, d = ae, q = V("common-radio-button"), A = ie, O = ne, b = oe, J = V("common-table"), K = re, Q = V("common-drawer"), z = Z("parse-time");
    return f(), y(Q, { ref_key: "drawerRef", ref: F, "append-to-body": "", modelValue: e(x), "onUpdate:modelValue": i[3] || (i[3] = (r) => $(x) ? x.value = r : null), "before-close": e(W), title: t.showType === "edit" ? "运输费变更" : "运输费历史记录", center: false, "close-on-click-modal": false, size: "800px" }, { titleAfter: l(() => [t.detailInfo.deliveryStatus === e(ye).RETURN.V && t.detailInfo.changeFreight === e(ge).CANCEL.V ? (f(), y(_, { key: 0, type: "warning" }, { default: l(() => i[4] || (i[4] = [E("已作废")])), _: 1, __: [4] })) : m("", true)]), titleRight: l(() => [t.showType === "edit" ? (f(), y(I, { key: 0, loading: C.value, type: "primary", size: "default", onClick: M }, { default: l(() => i[5] || (i[5] = [E("确认")])), _: 1, __: [5] }, 8, ["loading"])) : m("", true)]), content: l(() => [n(K, { ref_key: "formRef", ref: g, size: "default", model: o.value, rules: U, "label-width": "110px" }, { default: l(() => [a("div", Te, [a("div", _e, [t.showType === "edit" ? (f(), y(N, { key: 0 }, { default: l(() => i[6] || (i[6] = [a("span", { class: "title" }, "当前信息", -1)])), _: 1, __: [6] })) : m("", true), a("div", { class: T(t.showType === "detail" ? "flex-div" : "") }, [a("div", { class: T(t.showType === "detail" ? "child-div" : "") }, [t.showType === "detail" ? (f(), y(d, { key: 0, label: "承运日期" }, { default: l(() => [B(a("span", null, null, 512), [[z, { val: t.detailInfo.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : m("", true), n(d, { label: "所属项目" }, { default: l(() => [a("span", we, s(e(ve)(t.detailInfo.project)), 1)]), _: 1 }), n(d, { label: "物流公司" }, { default: l(() => [a("span", null, s(t.detailInfo.supplier && t.detailInfo.supplier.name), 1)]), _: 1 }), n(d, { label: "车次/船次编号" }, { default: l(() => [a("span", null, s(t.detailInfo.serialNumber), 1)]), _: 1 }), n(d, { label: "车牌/船牌号" }, { default: l(() => [a("span", null, s(t.detailInfo.licensePlate), 1)]), _: 1 }), n(d, { label: "司机姓名" }, { default: l(() => [a("span", null, s(t.detailInfo.driverName), 1)]), _: 1 })], 2), a("div", { class: T(t.showType === "detail" ? "child-div" : "") }, [n(d, { label: "车型" }, { default: l(() => [a("span", null, s(t.detailInfo.carModel), 1)]), _: 1 }), n(d, { label: "装载重量(t)" }, { default: l(() => [a("span", null, s(e(be)(t.detailInfo.actualWeight, "kg", "t", e(he).COM_WT__T)), 1)]), _: 1 }), n(d, { label: "计价方式" }, { default: l(() => [a("span", null, s(e(u).VL[t.detailInfo.priceType]), 1)]), _: 1 }), n(d, { label: "运输单价" }, { default: l(() => [a("span", xe, s(e(w)(t.detailInfo.supplier.price, e(v).bridge)), 1), a("span", { class: T(t.detailInfo.priceType === e(u).WEIGHT.V ? "blue" : "orange") }, s(e(u).V[t.detailInfo.priceType].unit), 3)]), _: 1 }), n(d, { label: "运输费" }, { default: l(() => [a("span", null, [a("span", Ie, s(t.detailInfo.totalPrice ? e(w)(t.detailInfo.totalPrice, e(v).bridge) : "-"), 1), i[7] || (i[7] = E("元"))])]), _: 1 })], 2)], 2)]), t.showType === "edit" ? (f(), D("div", Ve, [n(N, null, { default: l(() => i[8] || (i[8] = [a("span", { class: "title" }, "变更信息", -1)])), _: 1, __: [8] }), n(d, { label: "计价方式", prop: "priceType" }, { default: l(() => [n(q, { class: "filter-item", modelValue: o.value.priceType, "onUpdate:modelValue": i[0] || (i[0] = (r) => o.value.priceType = r), options: e(u).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(d, { label: o.value.priceType === e(u).WEIGHT.V ? "运输单价" : "运输费", prop: "price" }, { default: l(() => [n(A, { modelValue: o.value.price, "onUpdate:modelValue": i[1] || (i[1] = (r) => o.value.price = r), max: 999999999999, precision: e(v).bridge, step: 100, controls: false, style: { width: "150px", "margin-right": "3px" }, placeholder: "请填写", autocomplete: "off", onChange: j }, null, 8, ["modelValue", "precision"]), a("span", { class: T(o.value.priceType === e(u).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, s(e(u).V[o.value.priceType].unit), 3)]), _: 1 }, 8, ["label"]), o.value.priceType === e(u).WEIGHT.V ? (f(), y(d, { key: 0, label: "运输费" }, { default: l(() => [a("span", null, [a("span", Ee, s(e(w)(k.value, e(v).bridge)), 1), i[9] || (i[9] = E("元"))])]), _: 1 })) : m("", true), n(d, { label: "变更原因" }, { default: l(() => [n(O, { modelValue: o.value.remark, "onUpdate:modelValue": i[2] || (i[2] = (r) => o.value.remark = r), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "请填写", style: { width: "280px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })])) : m("", true)]), t.showType === "detail" ? (f(), y(N, { key: 0 }, { default: l(() => i[10] || (i[10] = [a("span", { class: "title" }, "历史运费记录", -1)])), _: 1, __: [10] })) : m("", true), t.showType === "detail" ? (f(), y(J, { key: 1, ref: "detailRef", border: "", data: P.value, "max-height": e(S), style: { width: "100%" }, class: "table-form", "return-source-data": "" }, { default: l(() => [n(b, { label: "序号", type: "index", align: "center", width: "55" }), n(b, { prop: "updateTime", label: "日期", align: "center" }, { default: l((r) => [B(a("span", null, null, 512), [[z, { val: r.row.updateTime, fmt: "{y}-{m}-{d} {h}:{i}:{s}" }]])]), _: 1 }), n(b, { prop: "priceType", label: "计价方式", align: "center" }, { default: l((r) => [a("span", null, s(e(u).VL[r.row.priceType]), 1)]), _: 1 }), n(b, { prop: "price", label: "运输单价", align: "right" }, { default: l((r) => [a("span", ke, s(e(w)(r.row.price, e(v).bridge)), 1), r.row.price ? (f(), D("span", { key: 0, class: T(r.row.priceType === e(u).WEIGHT.V ? "blue" : "orange") }, s(e(u).V[r.row.priceType].unit), 3)) : m("", true)]), _: 1 }), n(b, { prop: "price", label: "运输费（元）", align: "right" }, { default: l((r) => [a("span", Ce, s(e(w)(r.row.totalPrice, e(v).bridge)), 1)]), _: 1 }), n(b, { prop: "changeUserName", label: "价格录入人", align: "center" })]), _: 1 }, 8, ["data", "max-height"])) : m("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, Be = ue(Ne, [["__scopeId", "data-v-af3ef1de"]]);
export {
  Be as default
};
