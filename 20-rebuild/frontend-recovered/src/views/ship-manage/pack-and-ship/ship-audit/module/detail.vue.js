import { ref as h } from "vue";
import { inject as le } from "vue";
import { computed as oe } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as re } from "vue";
import { openBlock as c } from "vue";
import { createBlock as d } from "vue";
import { withCtx as t } from "vue";
import { withDirectives as y } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { renderSlot as ie } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as o } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as N } from "vue";
import { renderList as M } from "vue";
import { createCommentVNode as S } from "vue";
import { createElementVNode as U } from "vue";
import { isRef as ne } from "vue";
import { ElDescriptionsItem as se } from "element-plus";
import { ElDescriptions as ue } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElTag as de } from "element-plus";
import { ElImage as me } from "element-plus";
import { vLoading as pe } from "element-plus";
import { l as T, _ as fe, t as _e, u as be, o as we, z as ve, p as he, bs as p, K as ge, bw as H, bi as ye, D as Te, i as xe, ba as ke } from "../../../../../shared/runtime.js";
function Pe(r) {
  return T({ module: "mes", url: "cargo/review", method: "get", params: r });
}
function Ie(r) {
  return T({ module: "mes", url: `cargo/review/${r}`, method: "get" });
}
function je({ id: r, status: x }) {
  return T({ module: "mes", url: "cargo/review", method: "put", data: { id: r, status: x } });
}
function Be({ id: r }) {
  return T({ module: "mes", url: `cargo/review/${r}/download`, method: "get", responseType: "blob" });
}
const De = { class: "imgs-box" }, Ne = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, required: true }, projectType: { type: Number } }, emits: ["update:visible", "refresh"], setup(r, { emit: x }) {
  const { decimalPrecision: _ } = _e(), E = h(), O = x, v = r, { visible: k, handleClose: z } = be({ emit: O, props: v, field: "visible", showHook: G }), { maxHeight: $ } = we({ extraBox: [".el-drawer__header", ".other-content-top", ".other-content-bottom"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => E.value.loaded), q = le("permission"), b = h(false), m = h({}), V = h([]), Q = oe(() => v.detailInfo && v.detailInfo.id || void 0);
  function G() {
    K();
  }
  async function K() {
    try {
      b.value = true;
      const w = await Ie(Q.value);
      m.value = w, V.value = w.detailsList;
    } catch (f) {
      console.log("详情", f);
    } finally {
      b.value = false;
    }
  }
  function J(f) {
    return ke(f, { props: ["shipQuantity"] });
  }
  return (f, w) => {
    const W = g("print-table"), s = se, P = ue, u = ce, j = de, X = g("table-cell-tag"), Y = g("common-table"), Z = me, ee = g("common-drawer"), te = re("permission"), I = pe;
    return c(), d(ee, { ref_key: "drawerRef", ref: E, title: "发运审核", modelValue: l(k), "onUpdate:modelValue": w[0] || (w[0] = (e) => ne(k) ? k.value = e : null), direction: "rtl", "before-close": l(z), size: "80%" }, { titleAfter: t(() => [y(a(W, { "api-key": "mesShipmentAuditDetail", params: r.detailInfo.id, size: "mini", type: "warning" }, null, 8, ["params"]), [[te, l(q).detailPrint]])]), titleRight: t(() => [ie(f.$slots, "titleRight", {}, void 0, true)]), content: t(() => [y((c(), d(P, { class: "other-content-top", column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: t(() => [a(s, { label: "项目" }, { default: t(() => [n(o(l(ve)(r.detailInfo.project)), 1)]), _: 1 }), a(s, { label: "装车日期" }, { default: t(() => [n(o(l(he)(r.detailInfo.loadingTime)), 1)]), _: 1 }), a(s, { label: "装车人" }, { default: t(() => [n(o(r.detailInfo.userName), 1)]), _: 1 }), a(s, { label: "过磅人" }, { default: t(() => [n(o(r.detailInfo.actualUserName), 1)]), _: 1 }), a(s, { label: "物流单位" }, { default: t(() => {
      var e;
      return [n(o((e = r.detailInfo.supplier) == null ? void 0 : e.name), 1)];
    }), _: 1 }), a(s, { label: "车牌/船牌号" }, { default: t(() => [n(o(r.detailInfo.licensePlate), 1)]), _: 1 }), a(s, { label: "司机" }, { default: t(() => [n(o(r.detailInfo.driverName), 1)]), _: 1 }), a(s, { label: "司机电话" }, { default: t(() => [n(o(r.detailInfo.driverPhone), 1)]), _: 1 }), a(s, { label: "合同额" }, { default: t(() => {
      var e, i;
      return [n(o(l(p)((i = (e = m.value) == null ? void 0 : e.review) == null ? void 0 : i.contractAmount, l(_).shipment)), 1)];
    }), _: 1 }), a(s, { label: "累计收款" }, { default: t(() => {
      var e, i;
      return [n(o(l(p)((i = (e = m.value) == null ? void 0 : e.review) == null ? void 0 : i.totalCollectionAmount, l(_).shipment)), 1)];
    }), _: 1 }), a(s, { label: "累计发运额" }, { default: t(() => {
      var e, i;
      return [n(o(l(p)((i = (e = m.value) == null ? void 0 : e.review) == null ? void 0 : i.totalDeliveryAmount, l(_).shipment)), 1)];
    }), _: 1 }), a(s, { label: "本次获取价值" }, { default: t(() => {
      var e, i;
      return [n(o(l(p)((i = (e = m.value) == null ? void 0 : e.review) == null ? void 0 : i.deliveryAmount, l(_).shipment)), 1)];
    }), _: 1 })]), _: 1 })), [[I, b.value]]), y((c(), d(Y, { data: V.value || [], "show-summary": "", "summary-method": J, "max-height": l($), "empty-text": "暂无数据", style: { width: "100%" } }, { default: t(() => [a(u, { label: "序号", type: "index", align: "center", width: "60" }), a(u, { "show-overflow-tooltip": true, prop: "productType", align: "center", label: "产品类型", width: "90" }, { default: t((e) => [v.projectType === l(ge).BRIDGE.V ? (c(), d(j, { key: 0, type: l(H).V[e.row.productType].T, effect: "plain", style: { "margin-right": "5px" } }, { default: t(() => [n(o(l(H).VL[e.row.productType]), 1)]), _: 2 }, 1032, ["type"])) : (c(true), D(N, { key: 1 }, M(l(ye).ENUM, (i) => (c(), D(N, { key: i }, [e.row.productType & i.V ? (c(), d(j, { key: 0, type: i.T, effect: "plain", style: { "margin-right": "5px" } }, { default: t(() => [n(o(i.L), 1)]), _: 2 }, 1032, ["type"])) : S("", true)], 64))), 128))]), _: 1 }), a(u, { "show-overflow-tooltip": true, prop: "name", label: "名称/类型" }, { default: t((e) => [e.row.warehouseType === 1 ? (c(), d(X, { key: 0, name: "回厂返修", color: "#e64242", offset: 30 })) : S("", true), n(" " + o(e.row.name), 1)]), _: 1 }), a(u, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), a(u, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), a(u, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", align: "center" }, { default: t((e) => [n(o(l(p)(e.row.length, l(Te).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), a(u, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }), a(u, { "show-overflow-tooltip": true, align: "center", prop: "shipQuantity", label: "数量" }), a(u, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位" }), a(u, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量" }), a(u, { "show-overflow-tooltip": true, prop: "unitPrice", label: `单价
（元）`, align: "center" }, { default: t((e) => [n(o(l(p)(e.row.unitPrice, l(_).shipment)), 1)]), _: 1 }), a(u, { "show-overflow-tooltip": true, label: `总价
（元）`, align: "center" }, { default: t((e) => [n(o(l(xe)(e.row.totalPrice) ? l(p)(e.row.totalPrice, 3) : "-"), 1)]), _: 1 }), a(u, { "show-overflow-tooltip": true, prop: "packSerialNumber", label: "包单号", align: "center", width: "110" }, { default: t((e) => [n(o(e.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[I, b.value]]), y((c(), d(P, { class: "other-content-bottom", column: 1, border: "", style: { "margin-top": "10px" } }, { default: t(() => {
      var e, i, B;
      return [(B = (i = (e = m.value) == null ? void 0 : e.review) == null ? void 0 : i.attachmentDTOS) != null && B.length ? (c(), d(s, { key: 0, label: "装车图片" }, { default: t(() => {
        var R, A;
        return [U("div", De, [(c(true), D(N, null, M((A = (R = m.value) == null ? void 0 : R.review) == null ? void 0 : A.attachmentDTOS, (C) => {
          var L, F;
          return c(), d(Z, { "preview-src-list": (F = (L = m.value) == null ? void 0 : L.review) == null ? void 0 : F.attachmentDTOS.map((ae) => ae.imageUrl), "initial-index": 1, key: C.id, src: C.imageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]);
        }), 128))])];
      }), _: 1 })) : S("", true), a(s, { label: "备注" }, { default: t(() => [U("span", null, o(r.detailInfo.remark || "-"), 1)]), _: 1 })];
    }), _: 1 })), [[I, b.value]])]), _: 3 }, 8, ["modelValue", "before-close"]);
  };
} }, Se = fe(Ne, [["__scopeId", "data-v-3a8dfaaa"]]), Re = Object.freeze(Object.defineProperty({ __proto__: null, default: Se }, Symbol.toStringTag, { value: "Module" }));
export {
  je as a,
  Re as b,
  Be as d,
  Pe as g,
  Se as m
};
