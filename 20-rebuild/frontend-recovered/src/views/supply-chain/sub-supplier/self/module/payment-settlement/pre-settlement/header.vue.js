import { useStore as $ } from "vuex";
import { computed as m } from "vue";
import { inject as G } from "vue";
import { ref as h } from "vue";
import { watch as S } from "vue";
import { onMounted as J } from "vue";
import { reactive as _ } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { unref as s } from "vue";
import { withDirectives as W } from "vue";
import { createTextVNode as X } from "vue";
import { toDisplayString as Y } from "vue";
import { createBlock as Z } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElInput as te } from "element-plus";
import { nextTick as j } from "vue";
import { s as ae, d as oe } from "../../../../../../../modules/data-e72242cc.js";
import { uD as le, e3 as se, dp as re, cy as ne, e5 as ce, e2 as g, b as k, ec as O, e6 as E } from "../../../../../../../shared/runtime.js";
import { b as ie, d as de, i as ue } from "../../../../../../../modules/index-dfff0f60.js";
const pe = { class: "header-container" }, me = { key: 0, class: "notSlotValue truncate" }, be = { __name: "header", setup(he, { expose: N }) {
  const C = $(), L = m(() => C.getters.user.id), P = G("settlement_data"), { formData: t, projectInfo: d, tableList: u, contractListInfo: v } = P, p = h([]), c = h([]), U = m(() => le(se(oe, d)));
  S(() => L.value, (e) => {
    t.userId = e;
  }, { immediate: true });
  const x = async () => {
    try {
      const e = await ie();
      if (!e || Object.keys(e).length === 0) {
        p.value = [], g("warning", "暂无供应商");
        return;
      }
      p.value = Object.entries(e).map(([o, l]) => ({ id: Number(o), value: l, name: l }));
    } catch (e) {
      console.log("获取供应商失败:", e);
    }
  };
  J(() => {
    x();
  });
  const b = h([]), A = m(() => b.value.reduce((e, o) => (o.invoiceAmount && (e += o.invoiceAmount), e), 0)), V = _({ sum: 0, total: 0 });
  S(() => A.value, (e) => {
    V.sum = e;
  });
  const B = async () => {
    try {
      const e = await de({ supplierId: t.supplierId, boolSettleUse: true });
      if (!e || Object.keys(e).length === 0) {
        g("warning", "该分包商下暂无合同号"), c.value = [];
        return;
      }
      c.value = Object.entries(e).map(([o, l]) => ({ id: Number(o), name: l })).sort((o, l) => l.id - o.id);
    } catch (e) {
      console.error("获取采购合同列表失败:", e);
    }
  }, y = _({ total: 0 }), T = _({ pageSize: 10, pageNumber: 1 }), q = async () => {
    try {
      const e = await ue({ orderId: t.orderId, ...T });
      if (!e.supplierSettlementEchoDtoPageVO) return g("warning", "该合同号暂无付款及开票记录");
      b.value = e.supplierSettlementEchoDtoPageVO ? [...e.supplierSettlementEchoDtoPageVO] : [], await j(), y.total = e == null ? void 0 : e.totalElements;
      const o = O(e == null ? void 0 : e.supplierSettlementEchoDtoPageVO);
      u.splice(0), u.push(...o), await j(), e == null || delete e.supplierSettlementEchoDtoPageVO;
      const l = O([e]);
      Object.assign(v, ...l), Object.assign(d, ...l);
    } catch (e) {
      console.log(e);
    }
  }, I = () => {
    E(d), E(v), u.splice(0);
  }, F = () => {
    I(), t.orderId = null, c.value = [], k(t.supplierId) || B();
  }, R = async () => {
    I(), k(t.orderId) || await q();
  };
  return N({ recordInfo: y, invoiceInfo: V }), (e, o) => {
    const l = ee, D = K("common-select-v2"), z = te, H = Q("ellipsis");
    return f(), w("div", pe, [n(re, { "header-title": "基本信息" }), n(ce, { column: 2, "form-data": s(t), "form-rules": s(ae), "table-list": U.value }, { createTime: i(({ item: a }) => [n(l, { modelValue: s(t)[a], "onUpdate:modelValue": (r) => s(t)[a] = r, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), userId: i(({ item: a }) => [n(ne, { modelValue: s(t)[a], "onUpdate:modelValue": (r) => s(t)[a] = r, placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: i(({ item: a }) => [n(D, { modelValue: s(t)[a], "onUpdate:modelValue": (r) => s(t)[a] = r, options: p.value, clearable: "", filterable: "", placeholder: "请输入或选择分包商", type: "other", onChange: F }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), orderId: i(({ item: a }) => [n(D, { modelValue: s(t)[a], "onUpdate:modelValue": (r) => s(t)[a] = r, disabled: !c.value.length, options: c.value, clearable: "", filterable: "", placeholder: "请输入或选择分包合同号", onChange: R }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), projectName: i(({ val: a, label: r }) => [a ? W((f(), w("div", me, [X(Y(a.split("/").filter(Boolean).map((M) => `【${M}】`).join(" ")), 1)])), [[H]]) : (f(), Z(z, { key: 1, placeholder: r, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  be as default
};
