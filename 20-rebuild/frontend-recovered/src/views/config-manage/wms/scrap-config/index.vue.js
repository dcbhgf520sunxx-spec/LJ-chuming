import { ref as u } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as M } from "vue";
import { withDirectives as v } from "vue";
import { unref as t } from "vue";
import { createBlock as C } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as b } from "vue";
import { createVNode as n } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as j } from "element-plus";
import { g as F, _ as G, d as H } from "./module/detaile.vue.js";
import { J, G as L, hF as p } from "../../../../shared/runtime.js";
const R = { class: "app-container" }, W = { class: "head-container" }, Q = { __name: "index", setup(A) {
  const s = u(false), h = u({}), m = u([]), _ = u("创建废料类型");
  N(() => {
    i();
  });
  const { handleSizeChange: S, handleCurrentChange: k, total: z, setTotalPage: w, queryPage: g } = J({ fetchHook: i });
  async function i() {
    if (L(p.get)) {
      m.value = [];
      try {
        const { content: a, totalElements: e } = await F({ ...g });
        m.value = a, w(e);
      } catch (a) {
        console.log(a);
      }
    }
  }
  const x = () => {
    _.value = "创建废料类型", s.value = true;
  }, D = (a) => {
    _.value = "修改废料类型", h.value = a, s.value = true;
  }, V = () => {
    i();
  }, P = async (a) => {
    const e = [];
    e.push(a.id);
    try {
      await H(e), i();
    } catch (o) {
      console.log(o);
    }
  };
  return (a, e) => {
    const o = y("common-button"), c = U, T = y("common-table"), B = j, f = $("permission");
    return d(), q("div", R, [M("div", W, [v((d(), C(o, { icon: "el-icon-plus", type: "success", onClick: x, size: "default" }, { default: l(() => e[1] || (e[1] = [b("新增")])), _: 1, __: [1] })), [[f, t(p).add]])]), n(T, { data: m.value }, { default: l(() => [n(c, { label: "序号", align: "center", width: "80", type: "index" }), n(c, { label: "废料类型", align: "center", prop: "name" }), n(c, { label: "单位", align: "center", prop: "measureUnit" }), n(c, { label: "操作", align: "center" }, { default: l(({ row: r }) => [v((d(), C(o, { type: "primary", onClick: (E) => D(r), size: "default" }, { default: l(() => e[2] || (e[2] = [b("修改")])), _: 2, __: [2] }, 1032, ["onClick"])), [[f, t(p).edit]]), v((d(), C(o, { type: "danger", onClick: (E) => P(r), size: "default" }, { default: l(() => e[3] || (e[3] = [b("删除")])), _: 2, __: [3] }, 1032, ["onClick"])), [[f, t(p).del]])]), _: 1 })]), _: 1 }, 8, ["data"]), n(B, { total: t(z), "current-page": t(g).pageNumber, "page-size": t(g).pageSize, layout: "total, prev, pager, next, sizes", onSizeChange: t(S), onCurrentChange: t(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), n(G, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => s.value = r), onSuccess: V, rowData: h.value, title: _.value }, null, 8, ["modelValue", "rowData", "title"])]);
  };
} };
export {
  Q as default
};
