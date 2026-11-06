import { inject as U } from "vue";
import { ref as v } from "vue";
import { reactive as F } from "vue";
import { computed as M } from "vue";
import { onMounted as P } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as i } from "vue";
import { withCtx as p } from "vue";
import { unref as r } from "vue";
import { Fragment as T } from "vue";
import { renderList as H } from "vue";
import { createBlock as Q } from "vue";
import { ElOption as Z } from "element-plus";
import { ElSelect as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { e3 as G, dp as J, jb as y, e5 as K, e2 as _, b as C, ec as m, i as S, kZ as W } from "../../../../../../shared/runtime.js";
import { h as X, a as Y } from "../../../../../../modules/invoice-entry-de8cd325.js";
import { b as $, d as ee, e as ae } from "../../../../../../modules/index-dfff0f60.js";
const te = { class: "header-container" }, ie = { __name: "header", setup(oe, { expose: V }) {
  const L = U("invoice_data"), { formData: o, tableList: d, projectInfo: u } = L, f = v([]), l = v([]), j = F({ total: 0 }), k = M(() => G(Y, u)), w = async () => {
    try {
      const a = await $();
      if (!a || Object.keys(a).length === 0) {
        f.value = [], _("warning", "暂无供应商");
        return;
      }
      f.value = Object.entries(a).map(([e, t]) => ({ id: e, value: t, name: t }));
    } catch (a) {
      console.log("获取供应商失败:", a);
    }
  }, B = async () => {
    try {
      const a = await ee({ supplierId: o.supplierId });
      if (!a || Object.keys(a).length === 0) {
        _("warning", "该分包商下暂无合同号"), l.value = [];
        return;
      }
      l.value = Object.entries(a).map(([e, t]) => ({ id: Number(e), name: t })).sort((e, t) => t.id - e.id);
    } catch (a) {
      console.error("获取采购合同列表失败:", a);
    }
  }, O = async () => {
    var a;
    try {
      const e = await ae(o.orderId);
      if (!e) return _("warning", "暂无付款及发票记录");
      if (d.splice(0), e instanceof Array) {
        Object.assign(u, ...m([e[0]]));
        const t = m((a = e[0]) == null ? void 0 : a.dto);
        S(t) && d.push(...t);
      } else {
        Object.assign(u, ...m([e]));
        const t = m(e == null ? void 0 : e.dto);
        S(t) && d.push(...t);
      }
    } catch (e) {
      console.log("获取付款及发票记录失败" + e);
    }
  };
  P(() => {
    w();
  });
  const b = W(["supplierId", "orderId", "branchCompanyName", "amount", "basicClass", "settlementAmount"], u), g = () => {
    d.splice(0);
  }, E = () => {
    b("supplierId", () => {
      g(), o.orderId = null, l.value = [];
    }), C(o.supplierId) || B();
  }, N = async (a) => {
    b("orderId", () => {
      g();
    }), C(o.orderId) || await O();
  };
  return V({ recordInfo: j }), (a, e) => {
    const t = R("common-select-v2"), x = Z, A = q, D = z;
    return h(), I("div", te, [i(J, { "header-title": "基本信息" }), i(K, { column: 2, "form-data": r(o), "form-rules": r(X), "table-list": k.value }, { supplierId: p(({ item: n, blur: c }) => [i(t, { modelValue: r(o)[n], "onUpdate:modelValue": (s) => r(o)[n] = s, options: f.value, clearable: "", filterable: "", placeholder: "请输入或选择分包商", onBlur: c, onChange: E }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onBlur"])]), orderId: p(({ item: n, blur: c }) => [i(A, { modelValue: r(o)[n], "onUpdate:modelValue": (s) => r(o)[n] = s, disabled: !l.value.length, clearable: "", filterable: "", placeholder: "请输入或选择分包合同号", onBlur: c, onChange: N }, { default: p(() => [(h(true), I(T, null, H(l.value, (s) => (h(), Q(x, { key: s.id, label: s.name, value: s.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), subcontractClassId: p(({ val: n, label: c }) => [i(D, { "model-value": r(y).V[n] ? r(y).V[n].L : n, placeholder: c, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ie as default
};
