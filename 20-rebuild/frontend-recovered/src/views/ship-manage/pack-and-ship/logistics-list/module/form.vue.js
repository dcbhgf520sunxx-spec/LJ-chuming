import { ref as b } from "vue";
import { watch as X } from "vue";
import { nextTick as Y } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as a } from "vue";
import { normalizeClass as T } from "vue";
import { withDirectives as z } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as D } from "vue";
import { isRef as $ } from "vue";
import { ElNotification as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElDivider as le } from "element-plus";
import { ElFormItem as ae } from "element-plus";
import { ElInputNumber as ie } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElForm as re } from "element-plus";
import { a as se, c as de } from "../../../../../modules/logistics-list-4584a3aa.js";
import { _ as ue, t as pe, u as ce, o as me, bC as fe, bx as ye, bz as ge, z as ve, c as he, D as be, bB as u, bs as w, i as Te } from "../../../../../shared/runtime.js";
const _e = { style: { display: "flex" }, class: "detail-header" }, we = { style: { flex: "1", "padding-right": "8px" } }, xe = { class: "project-name" }, Ie = { style: { "margin-right": "3px" } }, Ve = { style: { "margin-right": "3px" } }, Ee = { key: 0, style: { flex: "1", "padding-left": "8px" } }, ke = { style: { "margin-right": "3px" } }, Ne = { style: { "margin-right": "3px" } }, Ce = { style: { "margin-right": "3px" } }, Fe = { __name: "form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: "detail" }, detailInfo: { type: Object, default: () => {
} }, projectType: { type: Number } }, emits: ["success", "update:modelValue"], setup(l, { emit: H }) {
  const { decimalPrecision: v } = pe(), c = l, g = b(), F = b(), k = b(), N = b(false), P = b([]), o = b(JSON.parse(JSON.stringify({ id: void 0, price: void 0, priceType: void 0, remark: void 0 }))), U = { price: { required: true, validator: (p, i, _) => {
    var I;
    Te(i) ? o.value.priceType === c.detailInfo.priceType && i === ((I = c.detailInfo.supplier) == null ? void 0 : I.price) && _(new Error("价格未变动")) : _(new Error("价格必填")), _();
  }, trigger: "blur" }, priceType: { required: true, message: "请选择计价方式", trigger: "change" } }, R = H, { visible: x, handleClose: B } = ce({ emit: R, props: c }), { maxHeight: S } = me({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 120 }, () => F.value.loaded);
  X(() => x.value, (p) => {
    p && (c.showType === "edit" ? G() : j());
  }, { deep: true, immediate: true });
  async function j() {
    try {
      P.value = await se(c.detailInfo.id) || [];
    } catch (p) {
      console.log("获取价格变更记录", p);
    }
  }
  function G() {
    var p;
    g.value && g.value.resetFields(), o.value.id = c.detailInfo.id, o.value.price = (p = c.detailInfo.supplier) == null ? void 0 : p.price, o.value.priceType = c.detailInfo.priceType, o.value.remark = void 0, k.value = c.detailInfo.totalPrice, g.value && Y(() => {
      g.value.clearValidate();
    }), fe(g, o);
  }
  function L() {
    k.value = o.value.priceType === u.WEIGHT.V ? c.detailInfo.actualWeight * o.value.price / 1e3 : void 0;
  }
  async function M() {
    N.value = true;
    try {
      if (!await g.value.validate()) return;
      await de.edit(o.value.id, o.value), ee({ title: "修改成功", type: "success" }), R("success"), B();
    } catch (p) {
      console.log("价格修改失败", p);
    } finally {
      N.value = false;
    }
  }
  return (p, i) => {
    const _ = te, I = V("common-button"), C = le, d = ae, q = V("common-radio-button"), A = ie, O = ne, h = oe, J = V("common-table"), K = re, Q = V("common-drawer"), W = Z("parse-time");
    return m(), y(Q, { ref_key: "drawerRef", ref: F, "append-to-body": "", modelValue: e(x), "onUpdate:modelValue": i[3] || (i[3] = (r) => $(x) ? x.value = r : null), "before-close": e(B), title: l.showType === "edit" ? "运输费变更" : "运输费历史记录", center: false, "close-on-click-modal": false, size: "800px" }, { titleAfter: t(() => [l.detailInfo.deliveryStatus === e(ye).RETURN.V && l.detailInfo.changeFreight === e(ge).CANCEL.V ? (m(), y(_, { key: 0, type: "warning" }, { default: t(() => i[4] || (i[4] = [E("已作废")])), _: 1, __: [4] })) : f("", true)]), titleRight: t(() => [l.showType === "edit" ? (m(), y(I, { key: 0, loading: N.value, type: "primary", size: "default", onClick: M }, { default: t(() => i[5] || (i[5] = [E("确认")])), _: 1, __: [5] }, 8, ["loading"])) : f("", true)]), content: t(() => [n(K, { ref_key: "formRef", ref: g, size: "default", model: o.value, rules: U, "label-width": "110px" }, { default: t(() => [a("div", _e, [a("div", we, [l.showType === "edit" ? (m(), y(C, { key: 0 }, { default: t(() => i[6] || (i[6] = [a("span", { class: "title" }, "当前信息", -1)])), _: 1, __: [6] })) : f("", true), a("div", { class: T(l.showType === "detail" ? "flex-div" : "") }, [a("div", { class: T(l.showType === "detail" ? "child-div" : "") }, [l.showType === "detail" ? (m(), y(d, { key: 0, label: "承运日期" }, { default: t(() => [z(a("span", null, null, 512), [[W, { val: l.detailInfo.auditTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : f("", true), n(d, { label: "所属项目" }, { default: t(() => [a("span", xe, s(e(ve)(l.detailInfo.project)), 1)]), _: 1 }), n(d, { label: "物流公司" }, { default: t(() => [a("span", null, s(l.detailInfo.supplier && l.detailInfo.supplier.name), 1)]), _: 1 }), n(d, { label: "车次/船次编号" }, { default: t(() => [a("span", null, s(l.detailInfo.serialNumber), 1)]), _: 1 }), n(d, { label: "车牌/船牌号" }, { default: t(() => [a("span", null, s(l.detailInfo.licensePlate), 1)]), _: 1 }), n(d, { label: "司机姓名" }, { default: t(() => [a("span", null, s(l.detailInfo.driverName), 1)]), _: 1 })], 2), a("div", { class: T(l.showType === "detail" ? "child-div" : "") }, [n(d, { label: "车型" }, { default: t(() => [a("span", null, s(l.detailInfo.carModel), 1)]), _: 1 }), n(d, { label: "装载重量(t)" }, { default: t(() => [a("span", null, s(e(he)(l.detailInfo.actualWeight, "kg", "t", e(be).COM_WT__T)), 1)]), _: 1 }), n(d, { label: "计价方式" }, { default: t(() => [a("span", null, s(e(u).VL[l.detailInfo.priceType]), 1)]), _: 1 }), n(d, { label: "运输单价" }, { default: t(() => [a("span", Ie, s(e(w)(l.detailInfo.supplier.price, e(v).shipment)), 1), a("span", { class: T(l.detailInfo.priceType === e(u).WEIGHT.V ? "blue" : "orange") }, s(e(u).V[l.detailInfo.priceType].unit), 3)]), _: 1 }), n(d, { label: "运输费" }, { default: t(() => [a("span", null, [a("span", Ve, s(l.detailInfo.totalPrice ? e(w)(l.detailInfo.totalPrice, e(v).shipment) : "-"), 1), i[7] || (i[7] = E("元"))])]), _: 1 })], 2)], 2)]), l.showType === "edit" ? (m(), D("div", Ee, [n(C, null, { default: t(() => i[8] || (i[8] = [a("span", { class: "title" }, "变更信息", -1)])), _: 1, __: [8] }), n(d, { label: "计价方式", prop: "priceType" }, { default: t(() => [n(q, { class: "filter-item", modelValue: o.value.priceType, "onUpdate:modelValue": i[0] || (i[0] = (r) => o.value.priceType = r), options: e(u).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(d, { label: o.value.priceType === e(u).WEIGHT.V ? "运输单价" : "运输费", prop: "price" }, { default: t(() => [n(A, { modelValue: o.value.price, "onUpdate:modelValue": i[1] || (i[1] = (r) => o.value.price = r), max: 999999999999, min: 0, precision: e(v).shipment, step: 100, controls: false, style: { width: "150px", "margin-right": "3px" }, placeholder: "请填写", autocomplete: "off", onChange: L }, null, 8, ["modelValue", "precision"]), a("span", { class: T(o.value.priceType === e(u).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, s(e(u).V[o.value.priceType].unit), 3)]), _: 1 }, 8, ["label"]), o.value.priceType === e(u).WEIGHT.V ? (m(), y(d, { key: 0, label: "运输费" }, { default: t(() => [a("span", null, [a("span", ke, s(e(w)(k.value, e(v).shipment)), 1), i[9] || (i[9] = E("元"))])]), _: 1 })) : f("", true), n(d, { label: "变更原因" }, { default: t(() => [n(O, { modelValue: o.value.remark, "onUpdate:modelValue": i[2] || (i[2] = (r) => o.value.remark = r), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "请填写", style: { width: "280px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })])) : f("", true)]), l.showType === "detail" ? (m(), y(C, { key: 0 }, { default: t(() => i[10] || (i[10] = [a("span", { class: "title" }, "历史运费记录", -1)])), _: 1, __: [10] })) : f("", true), l.showType === "detail" ? (m(), y(J, { key: 1, ref: "detailRef", border: "", data: P.value, "max-height": e(S), style: { width: "100%" }, class: "table-form", "return-source-data": "" }, { default: t(() => [n(h, { label: "序号", type: "index", align: "center", width: "55" }), n(h, { prop: "updateTime", label: "日期", align: "center" }, { default: t((r) => [z(a("span", null, null, 512), [[W, { val: r.row.updateTime, fmt: "{y}-{m}-{d} {h}:{i}:{s}" }]])]), _: 1 }), n(h, { prop: "priceType", label: "计价方式", align: "center" }, { default: t((r) => [a("span", null, s(e(u).VL[r.row.priceType]), 1)]), _: 1 }), n(h, { prop: "price", label: "运输单价", align: "right" }, { default: t((r) => [a("span", Ne, s(e(w)(r.row.price, e(v).shipment)), 1), r.row.price ? (m(), D("span", { key: 0, class: T(r.row.priceType === e(u).WEIGHT.V ? "blue" : "orange") }, s(e(u).V[r.row.priceType].unit), 3)) : f("", true)]), _: 1 }), n(h, { prop: "price", label: "运输费（元）", align: "right" }, { default: t((r) => [a("span", Ce, s(e(w)(r.row.totalPrice, e(v).shipment)), 1)]), _: 1 }), n(h, { prop: "changeUserName", label: "价格录入人", align: "center" })]), _: 1 }, 8, ["data", "max-height"])) : f("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, De = ue(Fe, [["__scopeId", "data-v-07438ca8"]]);
export {
  De as default
};
