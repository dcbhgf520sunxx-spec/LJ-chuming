import { inject as m } from "vue";
import { ref as a } from "vue";
import { computed as l } from "vue";
import { reactive as h } from "vue";
import { provide as f } from "vue";
import { watch as R } from "vue";
import { openBlock as y } from "vue";
import { createBlock as I } from "vue";
import { withCtx as i } from "vue";
import { createVNode as v } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as B } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { ElButton as H } from "element-plus";
import { ElDrawer as U } from "element-plus";
import q from "./calculation/index.vue.js";
import G from "./reverse-thrust/index.vue.js";
import { dp as J, e2 as g, e6 as b } from "../../../../../shared/runtime.js";
import { d as K, e as Q, g as W } from "../../../../../modules/drilling-config-d5ae6cbb.js";
import { a as X, e as Y } from "../../../../../modules/project-drilling-config-e57c94dd.js";
const ne = { __name: "index", setup(Z, { expose: j }) {
  const o = m("projectData"), r = a(false), S = a(false), c = a(""), D = a([]), T = l(() => o ? X : K), x = l(() => o ? Y : Q), n = h({ steelClassificationId: null, machinePartType: "" }), s = h({ steelClassificationId: null, processIdList: [], detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] });
  f("validateList", D), f("reverSetFromData", n), f("calculationFormData", s);
  const L = m("headerData"), { radio: C } = L, k = m("parentData"), { tableRef: A } = k, u = a(null), M = l(() => C.value === 1 ? "钻孔配置 -【实时计算模式】" : "钻孔配置 -【入库倒推模式】"), d = a("40%"), z = [null, q, G], F = l(() => z[C.value]), p = a(null);
  R([() => n, () => s], ([t, e]) => {
    t.id || e.id ? c.value = "修改" : c.value = "创建", s.statisticsMode === 3 ? d.value = "45%" : d.value = "40%";
  }, { deep: true, immediate: true }), (async () => {
    try {
      const t = await W();
      t.id && (u.value = t.mode);
    } catch (t) {
      console.log(t);
    }
  })();
  const O = async () => {
    D.value.forEach(async (t) => {
      try {
        await t();
        const e = p.value.formData;
        if (u.value) e.statisticsConfigStatisticsMode = u.value;
        else return g("error", "请先前往统计配置页面配置模式");
        e.id ? (await x.value({ ...e, contractProjectId: o ? o.contractProjectId : null }), g("success", "修改成功")) : (await T.value({ ...e, contractProjectId: o ? o.contractProjectId : null }), g("success", "创建成功")), _(), A.value.getDrillConfigList();
      } catch (e) {
        console.log(e);
      }
    });
  }, _ = () => {
    r.value = false, b(n), b(s);
  };
  return j({ visible: r, reverSetFromData: n, currentComponentRef: p, calculationFormData: s }), (t, e) => {
    const w = H, V = U;
    return y(), I(V, { modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (E) => r.value = E), "close-on-click-modal": false, "close-on-press-escape": false, size: d.value, "destroy-on-close": "", "show-close": false }, { header: i(() => [v(J, { "header-title": M.value, "type-one": false }, null, 8, ["header-title"]), v(w, { plain: "", onClick: _ }, { default: i(() => e[1] || (e[1] = [P("关闭")])), _: 1, __: [1] }), v(w, { type: "success", onClick: O, loading: S.value }, { default: i(() => [P(B(c.value), 1)]), _: 1 }, 8, ["loading"])]), default: i(() => [(y(), I(N(F.value), { ref_key: "currentComponentRef", ref: p }, null, 512))]), _: 1 }, 8, ["modelValue", "size"]);
  };
} };
export {
  ne as default
};
