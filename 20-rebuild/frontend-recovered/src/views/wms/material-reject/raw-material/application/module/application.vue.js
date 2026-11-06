import { inject as le } from "vue";
import { computed as v } from "vue";
import { ref as u } from "vue";
import { watch as ue } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as l } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as L } from "vue";
import { withDirectives as re } from "vue";
import { unref as h } from "vue";
import { createCommentVNode as y } from "vue";
import { Fragment as D } from "vue";
import { createBlock as R } from "vue";
import { isRef as ce } from "vue";
import { ElBadge as me } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { g as fe } from "../../../../../../modules/application-f2aa112e.js";
import { t as pe, jX as ve, bD as be, D as o, u as he, o as je, G as ge, jZ as Ne, jV as ye, cS as x, bs as j, kD as w, cO as B, jl as M, AH as Ae, xn as _e, aR as xe, i as Ve, AI as Ee, jG as Te, k5 as Pe, jH as Ue, jI as Re, k6 as Se, xl as ke, a$ as Ie, V as Ce, AJ as Fe, ba as Le, jN as De } from "../../../../../../shared/runtime.js";
import we from "../../components/reject-match-info.vue.js";
import Be from "./preview.vue.js";
import "../../../../../../modules/vertical-label-c3028fe0.js";
import "./preview-confirm.vue.js";
const Me = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px" } }, Je = { __name: "application", props: { visible: { type: Boolean, default: false }, inboundId: { type: Number } }, emits: ["success", "update:visible"], setup($, { emit: Y }) {
  const { decimalPrecision: A } = pe(), S = Y, k = $, I = le("permission"), H = v(() => [...ve, ["invoiceType", ["parse-enum", be, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", A.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", A.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", A.value.wms]], ["unitPriceNoFreight", ["to-thousand", A.value.wms]], ["amount", ["to-thousand", o.YUAN]], ["amountExcludingVAT", ["to-thousand", o.YUAN]], ["amountNoFreight", ["to-thousand", o.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", o.YUAN]], ["inputVAT", ["to-thousand", o.YUAN]], ["inputVATNoFreight", ["to-thousand", o.YUAN]]]), K = u(), m = u([]), g = u(false), s = u({}), V = u(false), E = u(false), _ = u(), d = u({}), T = u(), C = u(0), { visible: N, handleClose: F } = he({ emit: S, props: k, field: "visible" }), { maxHeight: q } = je({ mainBox: ".raw-mat-reject-application-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, N), z = v(() => ge(I.showAmount)), f = v(() => s.value.purchaseOrder || {}), O = v(() => {
    var t;
    return ((t = f.value) == null ? void 0 : t.supplyType) === Ne.PARTY_A.V;
  }), G = v(() => f.value.logisticsPayerType === ye.DEMAND.V), J = v(() => g.value ? "入库单" : `入库单：${s.value.serialNumber}（ ${f.value.supplier ? f.value.supplier.name : ""} ）`);
  ue(N, (t) => {
    t && (X(), Z(k.inboundId));
  });
  function W(t) {
    V.value = true, _.value = t, T.value = d.value[t.id].KV;
  }
  function X() {
    g.value = false, s.value = {}, d.value = {}, T.value = void 0, _.value = void 0, m.value = [];
  }
  async function Z(t) {
    if (t) try {
      g.value = true;
      const a = await fe(t);
      s.value = await Q(a), s.value.list.forEach((e) => {
        d.value[e.id] = { KV: {}, material: e }, e.totalNumber = e.rejectUnitType === x.MEASURE.V ? e.quantity : e.mete, e.rejectNumber = 0, e.rejectPendingNumber = 0, Array.isArray(e.rejectList) && e.rejectList.forEach((n) => {
          const r = n.material;
          let p = e.rejectUnitType === x.MEASURE.V ? r.quantity : r.mete;
          p = +j(p, e.rejectUnitPrecision), n.reviewStatus === w.UNREVIEWED.V && (e.rejectPendingNumber += p), n.reviewStatus === w.PASS.V && (e.rejectNumber += p);
        }), e.rejectNumber = +j(e.rejectNumber, e.rejectUnitPrecision), e.rejectPendingNumber = +j(e.rejectPendingNumber, e.rejectUnitPrecision), e.rejectMaxNumber = +j(e.totalNumber - e.rejectNumber - e.rejectPendingNumber, e.rejectUnitPrecision);
      });
    } catch (a) {
      console.error("退库-获取入库详情", a);
    } finally {
      g.value = false;
    }
  }
  async function Q(t) {
    await B(t.list), await M(t.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
    const a = [];
    return t.list.forEach((e) => {
      Array.isArray(e.rejectList) ? (e.rejectList.forEach((n) => {
        a.push(n.material);
      }), e.allRejectList = [...e.rejectList]) : e.rejectList = [];
    }), await B(a), await M(a, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), t;
  }
  function ee(t) {
    m.value.findIndex((n) => n === t.id) === -1 && m.value.push(t.id);
    const e = Ie(d.value[t.id].KV);
    t.allRejectList = t.rejectList.concat(e.map((n) => {
      const r = Ce(n);
      return t.measureUnit && (r.quantity = t.rejectUnitType === x.MEASURE.V ? n.rejectNumber : j(n.rejectNumber * t.accountingUnitNet, t.measurePrecision)), r.mete = t.rejectUnitType === x.ACCOUNTING.V ? n.rejectNumber : j(n.rejectNumber * t.unitNet, t.accountingPrecision), { reviewStatus: Fe.UNSUBMITTED.V, material: r, realTime: r.realTime };
    }));
  }
  function te(t, a) {
    const e = d.value[t.id].KV;
    delete e[a.material.id];
  }
  function ae() {
    F(), S("success");
  }
  function ie(t) {
    return Le(t, { props: ["quantity", ["mete", De.weight.precision], ["amount", o.YUAN], ["amountExcludingVAT", o.YUAN], ["inputVAT", o.YUAN], ["amountNoFreight", o.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (t, a) => {
    const e = P("common-button"), n = me, r = de, p = P("common-table"), se = P("common-drawer"), ne = oe("permission");
    return b(), U(D, null, [l(se, { ref_key: "drawerRef", ref: K, modelValue: h(N), "onUpdate:modelValue": a[2] || (a[2] = (i) => ce(N) ? N.value = i : null), "content-loading": g.value, "before-close": h(F), title: J.value, "show-close": "", size: "100%", "custom-class": "raw-mat-reject-application-form" }, { titleAfter: c(() => [l(Ae, { order: f.value, detail: s.value }, null, 8, ["order", "detail"])]), titleRight: c(() => [l(n, { value: C.value, hidden: C.value < 1 }, { default: c(() => [l(e, { size: "default", type: "primary", onClick: a[0] || (a[0] = (i) => E.value = true) }, { default: c(() => a[6] || (a[6] = [L("本次退货预览")])), _: 1, __: [6] })]), _: 1 }, 8, ["value", "hidden"]), re(l(_e, { "purchase-id": f.value.id, size: "default" }, null, 8, ["purchase-id"]), [[ne, h(I).purchaseOrderDetail]])]), content: c(() => [l(p, { data: s.value.list, "data-format": H.value, "max-height": h(q), "show-summary": "", "summary-method": ie, "expand-row-keys": m.value, "row-key": "id" }, { default: c(() => [l(xe, { data: s.value.list, "expand-row-keys": m.value, "onUpdate:expandRowKeys": a[1] || (a[1] = (i) => m.value = i), "row-key": "id" }, { default: c(({ row: { sourceRow: i } }) => [h(Ve)(i.allRejectList) ? (b(), U("div", Me, [l(Ee, { stripe: false, material: i, "basic-class": i.basicClass, list: i.allRejectList, operable: "", onDel: te, style: { width: "1600px" } }, null, 8, ["material", "basic-class", "list"])])) : y("", true)]), _: 1 }, 8, ["data", "expand-row-keys"]), l(Te, { "basic-class": s.value.basicClass, "show-reject-status": "" }, null, 8, ["basic-class"]), l(Pe, { "basic-class": s.value.basicClass }, null, 8, ["basic-class"]), l(Ue, { "basic-class": s.value.basicClass }, null, 8, ["basic-class"]), z.value ? (b(), U(D, { key: 0 }, [O.value ? y("", true) : (b(), R(Re, { key: 0, showFreight: G.value }, null, 8, ["showFreight"]))], 64)) : y("", true), l(Se, { "show-project": "", "show-monomer": false, "show-area": false }), l(r, { label: "操作", width: "100", align: "center", fixed: "right" }, { default: c(({ row: { sourceRow: i } }) => [i.rejectStatus !== h(ke).ALL.V ? (b(), R(e, { key: 0, type: "warning", size: "default", onClick: ($e) => W(i) }, { default: c(() => a[7] || (a[7] = [L(" 退货 ")])), _: 2, __: [7] }, 1032, ["onClick"])) : y("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]), l(we, { visible: V.value, "onUpdate:visible": a[3] || (a[3] = (i) => V.value = i), material: _.value, "reject-info": T.value, onChange: a[4] || (a[4] = (i) => ee(_.value)) }, null, 8, ["visible", "material", "reject-info"]), s.value.id ? (b(), R(Be, { key: 0, visible: E.value, "onUpdate:visible": a[5] || (a[5] = (i) => E.value = i), "reject-info": d.value, detailInfo: s.value, "basic-class": s.value.basicClass, "inbound-id": s.value.id, onSuccess: ae }, null, 8, ["visible", "reject-info", "detailInfo", "basic-class", "inbound-id"])) : y("", true)], 64);
  };
} };
export {
  Je as default
};
