import { inject as k } from "vue";
import { computed as B } from "vue";
import { ref as T } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as f } from "vue";
import { createBlock as h } from "vue";
import { withCtx as i } from "vue";
import { createVNode as s } from "vue";
import { unref as l } from "vue";
import { createTextVNode as E } from "vue";
import { createElementBlock as C } from "vue";
import { Fragment as S } from "vue";
import { renderList as H } from "vue";
import { isRef as L } from "vue";
import { ElNotification as N } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { l as q, ai as z, u as P, o as Q, b as R, aT as $ } from "../../../../../shared/runtime.js";
import { _ as I } from "../../../../../modules/index-61ce89a1.js";
function U(p) {
  return q({ module: "mes", url: "process/wage", method: "post", data: p });
}
const D = { __name: "preview", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] } }, emits: ["saveSuccess", "update:visible"], setup(p, { emit: w }) {
  const g = w, _ = p, n = k("crud"), u = B(() => _.data.filter((a) => !z(a.originPriceMap, a.priceMap))), d = T(false), { visible: r, handleClose: b } = P({ emit: g, props: _, field: "visible" }), { maxHeight: x } = Q({ mainBox: ".wage-quota", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, r);
  async function v() {
    try {
      d.value = true;
      const a = [];
      u.value.forEach((e) => {
        var c;
        for (const o in e.priceMap) e.priceMap[o] !== e.originPriceMap[o] && a.push({ processId: e.id, wageQuotaType: o, price: e.priceMap[o], organizationType: (c = n == null ? void 0 : n.query) == null ? void 0 : c.organizationType });
      }), await U(a), b(), n.refresh(), g("saveSuccess"), N({ title: "修改成功", type: "success" });
    } catch (a) {
      console.log("工价定额批量修改", a);
    } finally {
      d.value = false;
    }
  }
  return (a, e) => {
    const c = m("common-button"), o = j, M = m("common-table"), V = m("common-dialog");
    return f(), h(V, { "custom-class": "wage-quota", title: "变更提交预览", "append-to-body": "", modelValue: l(r), "onUpdate:modelValue": e[0] || (e[0] = (t) => L(r) ? r.value = t : null), width: "1200px", "before-close": l(b), top: "5vh" }, { titleRight: i(() => [s(c, { loading: d.value, disabled: l(R)(u.value), type: "primary", size: "default", onClick: v }, { default: i(() => e[1] || (e[1] = [E("保 存")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: i(() => [s(M, { data: u.value, "max-height": l(x), "empty-text": "未做改动", "row-key": "id" }, { default: i(() => [s(o, { label: "序号", type: "index", align: "center", width: "60" }), s(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序名称", width: "140px", align: "center" }), (f(true), C(S, null, H(l($).ENUM, (t) => (f(), h(o, { key: t.V, label: `${t.L} (${t.unit})`, "min-width": "170px", align: "center" }, { default: i(({ row: y }) => [s(l(I), { old: y.originPriceMap[t.V], new: y.priceMap[t.V] }, null, 8, ["old", "new"])]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  D as default
};
