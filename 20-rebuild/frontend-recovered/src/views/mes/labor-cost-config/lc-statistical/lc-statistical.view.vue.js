import { l as E, e2 as N, _ as U, nT as g, ez as C, G as v, nU as y } from "../../../../shared/runtime.js";
import { ref as D } from "vue";
import { reactive as k } from "vue";
import { watch as h } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { unref as a } from "vue";
import { createVNode as u } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as o } from "vue";
import { createTextVNode as b } from "vue";
import { ElCard as S } from "element-plus";
import { createCommentVNode as V } from "vue";
import { createBlock as w } from "vue";
import { Fragment as B } from "vue";
import { renderList as M } from "vue";
import { toDisplayString as O } from "vue";
import { ElDatePicker as L } from "element-plus";
const T = () => E({ method: "get", url: `
				api
				/system
				/statistics-config
				/price-modify-config/detail
			`, cancelKey: false }), A = (t) => E({ method: "put", url: `
				api
				/system
				/statistics-config
				/price-modify-config
				/edit
			`, data: t, cancelKey: false }), I = () => E({ method: "get", url: `
				api
				/system
				/statistics-config
				/statistics-mode-config
				/detail
			`, cancelKey: false }), K = async () => T().then((t) => ({ id: t.id, data: [{ scope: t.configPrice, date: [t.configPriceSyncStartDate, t.configPriceSyncEndDate] }, { scope: t.individualPrice, date: [t.individualPriceSyncStartDate, t.individualPriceSyncEndDate] }] })), R = (t) => {
  const c = JSON.parse(JSON.stringify(t));
  c.data.forEach((s) => {
    s.date.length === 0 ? s.date = ["", ""] : s.date.forEach((i, e, m) => m[e] = new Date(i).getTime());
  });
  const n = { id: c.id, configPrice: c.data[0].scope };
  return A(n).then(() => {
    N("success", "操作成功");
  });
}, F = async () => I().then((t) => ({ id: t.id, mode: t.mode, date: t.deadline }));
const $ = { class: "lc-statistical" }, j = { key: 0, class: "lc-statistical__mode-configure" }, H = { class: "el-card__x-body" }, J = { key: 1, class: "lc-statistical__price-configure" }, z = { class: "el-card__x-header" }, G = { class: "x-button" }, q = { class: "el-card__x-body" }, Q = { __name: "lc-statistical.view", setup(t) {
  const c = ["配置价格修改场景"], n = D([]), s = k({ modeConfigure: { id: "", mode: -1, date: "" }, priceConfigure: { id: "", data: [{ scope: -1, date: [] }, { scope: -1, date: [] }] } });
  return F().then((i) => {
    s.modeConfigure = i;
  }), K().then((i) => {
    s.priceConfigure = i;
  }), h(() => s.modeConfigure.mode, (i) => {
    g.INBOUND_PUSHBACK.V === i ? n.value = [C.BEFOR.V] : n.value = [];
  }, { immediate: true, deep: true }), (i, e) => {
    const m = P("common-radio"), x = P("common-button");
    return r(), p("div", $, [a(v)(a(y).priceConfigView) ? (r(), p("div", j, [u(a(S), null, { default: l(() => [o("div", H, [u(m, { options: a(g).ENUM, disabledVal: [a(g).REAL_TIME.V], type: "enum", modelValue: s.modeConfigure.mode, "onUpdate:modelValue": e[0] || (e[0] = (f) => s.modeConfigure.mode = f) }, { REAL_TIME: l(() => e[2] || (e[2] = [o("span", { class: "x-text" }, "选择此模式，薪酬的计件的统计，则根据班组实时报工数据，由系统自动根据零构件类型结合工价，实时生成计件薪酬表 ", -1)])), INBOUND_PUSHBACK: l(() => e[3] || (e[3] = [o("span", { class: "x-text" }, "选择此模式，薪酬的计件统计，则根据月末实际制成品入库数据结合工价生成月度计件薪酬表，该模式零件必须一口价 ", -1)])), _: 1 }, 8, ["options", "disabledVal", "modelValue"]), e[4] || (e[4] = o("div", { class: "date" }, [o("span", { class: "text" }, " 统计截止日: "), b(" 月底 ")], -1)), e[5] || (e[5] = o("div", { class: "tips" }, null, -1))])]), _: 1 })])) : V("", true), a(v)(a(y).priceConfigView) ? (r(), p("div", J, [u(a(S), null, { header: l(() => [o("div", z, [e[7] || (e[7] = o("span", null, "价格修改配置", -1)), o("div", G, [a(v)(a(y).editPriceConfig) ? (r(), w(x, { key: 0, onClick: e[1] || (e[1] = () => a(R)(s.priceConfigure)) }, { default: l(() => e[6] || (e[6] = [b("保 存 ")])), _: 1, __: [6] })) : V("", true)])])]), default: l(() => [o("div", q, [(r(), p(B, null, M(c, (f, d) => o("div", { key: d, class: "screen" }, [o("span", null, O(f), 1), u(m, { options: a(C).ENUM, disabledVal: n.value, type: "enum", modelValue: s.priceConfigure.data[d].scope, "onUpdate:modelValue": (_) => s.priceConfigure.data[d].scope = _ }, null, 8, ["options", "disabledVal", "modelValue", "onUpdate:modelValue"]), u(a(L), { type: "daterange", disabled: !!n.value.length || s.priceConfigure.data[d].scope === a(C).AFTER.V, modelValue: s.priceConfigure.data[d].date, "onUpdate:modelValue": (_) => s.priceConfigure.data[d].date = _ }, null, 8, ["disabled", "modelValue", "onUpdate:modelValue"])])), 64))])]), _: 1 })])) : V("", true)]);
  };
} }, Y = U(Q, [["__scopeId", "data-v-7b9f6f92"]]);
export {
  Y as default
};
