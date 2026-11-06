import { ref as T } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { unref as d } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as g } from "vue";
import { createElementVNode as s } from "vue";
import { createElementBlock as N } from "vue";
import { Fragment as q } from "vue";
import { renderList as R } from "vue";
import { isRef as G } from "vue";
import { ElNotification as D } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElPopconfirm as M } from "element-plus";
import { ElFormItem as K } from "element-plus";
import { ElImage as Q } from "element-plus";
import { ElForm as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as I, _ as Y, u as Z, c3 as f, G as ee, L as te, z as le } from "../../../../../shared/runtime.js";
function ae(t) {
  return I({ module: "project", url: "qhse-problem", method: "get", params: t });
}
function se(t) {
  return I({ module: "project", url: "qhse-change/check", method: "put", data: t });
}
function oe(t) {
  return I({ module: "project", url: `qhse-problem/print/${t}`, method: "get", responseType: "blob" });
}
function ne(t) {
  return I({ module: "project", url: `qhse-problem/closeById/${t}`, method: "put" });
}
const ge = { get: ae };
const ie = { class: "project-name" }, de = { style: { display: "flex" } }, re = { style: { display: "flex" } }, ce = { style: { display: "flex" } }, ue = { class: "imgs-box" }, me = { style: { display: "flex" } }, fe = { class: "imgs-box" }, ye = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: "detail" } }, emits: ["success", "update:modelValue"], setup(t, { emit: P }) {
  const w = P, x = t, { visible: k, handleClose: C } = Z({ emit: w, props: x }), r = T(false), A = T();
  async function B() {
    try {
      await ne(x.detailInfo.qhseChange.id), r.value = false, D({ title: "问题关闭成功", type: "success" }), w("success"), C();
    } catch (y) {
      r.value = false, console.log("问题关闭失败", y);
    }
  }
  async function j(y) {
    var v;
    r.value = true;
    const a = y === f.PASS.V ? "通过成功" : "驳回成功";
    try {
      const u = { auditStatus: y, id: (v = x.detailInfo.qhseChange) == null ? void 0 : v.id };
      await se(u), r.value = false, D({ title: "审核" + a, type: "success" }), w("success"), C();
    } catch (u) {
      r.value = false, console.log("问题审核失败", u);
    }
  }
  return (y, a) => {
    const v = H, u = z("common-button"), F = M, n = K, E = Q, L = W, $ = z("common-drawer"), S = X, O = V("parse-time"), U = V("thousand"), J = V("empty-text");
    return i(), c($, { ref_key: "detailRef", ref: A, "append-to-body": "", "close-on-click-modal": false, "before-close": d(C), modelValue: d(k), "onUpdate:modelValue": a[2] || (a[2] = (e) => G(k) ? k.value = e : null), title: "问题报告", "wrapper-closable": false, size: "50%" }, { titleAfter: l(() => [o(v, { type: t.detailInfo.auditStatus === d(f).PASS.V ? "success" : t.detailInfo.auditStatus === d(f).REJECT.V ? "warning" : "primary" }, { default: l(() => [b(m(d(f).VL[t.detailInfo.auditStatus]), 1)]), _: 1 }, 8, ["type"])]), titleRight: l(() => [d(ee)(t.permission.download) ? (i(), c(te, { key: 0, params: t.detailInfo.id, fn: d(oe) }, { default: l(() => a[3] || (a[3] = [b("下载问题报告")])), _: 1, __: [3] }, 8, ["params", "fn"])) : h("", true), t.showType === "close" ? (i(), c(F, { key: 1, "confirm-button-text": "确定", "cancel-button-text": "取消", icon: "el-icon-info", "icon-color": "red", title: "确认关闭问题吗?", onConfirm: B }, { reference: l(() => [g((i(), c(u, { size: "default", type: "primary" }, { default: l(() => a[4] || (a[4] = [b("关闭问题")])), _: 1, __: [4] })), [[S, r.value]])]), _: 1 })) : h("", true), t.showType === "audit" ? g((i(), c(u, { key: 2, size: "default", type: "info", onClick: a[0] || (a[0] = (e) => j(d(f).REJECT.V)) }, { default: l(() => a[5] || (a[5] = [b("驳回")])), _: 1, __: [5] })), [[S, r.value]]) : h("", true), t.showType === "audit" ? g((i(), c(u, { key: 3, size: "default", type: "success", onClick: a[1] || (a[1] = (e) => j(d(f).PASS.V)) }, { default: l(() => a[6] || (a[6] = [b("通过")])), _: 1, __: [6] })), [[S, r.value]]) : h("", true)]), content: l(() => [o(L, { ref: "formRef", size: "default", "label-width": "130px" }, { default: l(() => [o(n, { label: "所属项目" }, { default: l(() => {
      var e;
      return [s("span", ie, m(d(le)((e = t.detailInfo) == null ? void 0 : e.project)), 1)];
    }), _: 1 }), s("div", de, [o(n, { label: "分包单位", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [s("span", null, m((e = t.detailInfo) == null ? void 0 : e.supplierName), 1)];
    }), _: 1 }), o(n, { label: "分类", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [s("span", null, m((e = t.detailInfo) == null ? void 0 : e.subcontractClassName), 1)];
    }), _: 1 })]), s("div", re, [o(n, { label: "日期", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [g(s("span", null, null, 512), [[O, { val: (e = t.detailInfo) == null ? void 0 : e.problemDate, fmt: "{y}-{m}-{d}" }]])];
    }), _: 1 }), o(n, { label: "问题分类", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [s("span", null, m((e = t.detailInfo) == null ? void 0 : e.problemTypeName), 1)];
    }), _: 1 })]), o(n, { label: "违约金" }, { default: l(() => {
      var e;
      return [g(s("span", null, null, 512), [[U, (e = t.detailInfo) == null ? void 0 : e.penalty], [J]])];
    }), _: 1 }), s("div", ce, [o(n, { label: "整改前", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [s("div", ue, [(i(true), N(q, null, R((e = t.detailInfo) == null ? void 0 : e.beforeChangeImgs, (p) => {
        var _;
        return i(), c(E, { "preview-src-list": (_ = t.detailInfo) == null ? void 0 : _.beforeImgSrc, "initial-index": 1, key: p.id, src: p.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]);
      }), 128))])];
    }), _: 1 }), o(n, { label: "整改前描述", style: { width: "50%" } }, { default: l(() => [s("span", null, m(t.detailInfo.remark || "-"), 1)]), _: 1 })]), s("div", me, [o(n, { label: "整改后", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [s("div", fe, [(i(true), N(q, null, R((e = t.detailInfo) == null ? void 0 : e.afterChangeImgs, (p) => {
        var _;
        return i(), c(E, { "preview-src-list": (_ = t.detailInfo) == null ? void 0 : _.afterImgSrc, "initial-index": 1, key: p.id, src: p.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]);
      }), 128))])];
    }), _: 1 }), o(n, { label: "整改后描述", style: { width: "50%" } }, { default: l(() => {
      var e;
      return [s("span", null, m(((e = t.detailInfo.qhseChange) == null ? void 0 : e.problemDesc) || "-"), 1)];
    }), _: 1 })])]), _: 1 }, 512)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, pe = Y(ye, [["__scopeId", "data-v-220c9908"]]), ve = Object.freeze(Object.defineProperty({ __proto__: null, default: pe }, Symbol.toStringTag, { value: "Module" }));
export {
  ge as c,
  ve as d,
  pe as m
};
