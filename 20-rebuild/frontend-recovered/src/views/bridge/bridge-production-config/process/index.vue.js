import { useStore as P } from "vuex";
import { ref as C } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as O } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as d } from "vue";
import { createVNode as b } from "vue";
import { ElTableColumn as v } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as A } from "../../../../modules/process-66f2e55f.js";
import { x as L, aG as g, o as R, aD as s, V as x, G as H, an as K } from "../../../../shared/runtime.js";
import q from "./module/form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const V = { class: "app-container" }, U = { __name: "index", setup(B) {
  const m = P(), y = [["productType", ["parse-enum", s, { bit: true }]]], u = C(), { crud: l, columns: f, CRUD: p } = L({ title: "工序", sort: [], permission: { ...g }, hasPagination: false, crudApi: { ...A } }, u), { maxHeight: T } = R(), _ = { [s.BOX.K]: "boxProcessList", [s.CELL.K]: "elementProcessList", [s.MACHINE_PART.K]: "machinePartProcessList" };
  return p.HOOK.handleRefresh = (w, { data: n }) => {
    n.content = [];
    for (const t in _) {
      const a = n[_[t]], r = x(a);
      let o = "";
      r && r.length > 0 ? o = r.map((E) => `【${E.name}】`).join("") : o = "", n.content.push({ productType: s.KV[t], list: a, source: x(a), processSequence: o });
    }
  }, p.HOOK.afterSubmit = () => {
    m.commit("config/SET_LOADED", { key: "process", loaded: false });
  }, p.HOOK.afterDelete = () => {
    m.commit("config/SET_LOADED", { key: "process", loaded: false });
  }, (w, n) => {
    const t = v, a = D("common-table"), r = S;
    return c(), k("div", V, [O((c(), i(a, { ref_key: "tableRef", ref: u, "data-format": y, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(T), style: { width: "100%" } }, { default: h(() => [e(f).visible("productType") ? (c(), i(t, { key: "productType", prop: "productType", "show-overflow-tooltip": true, label: "类型", width: "140px", align: "center" })) : d("", true), e(f).visible("processSequence") ? (c(), i(t, { key: "processSequence", prop: "processSequence", "show-overflow-tooltip": true, label: "工序", "min-width": "160px" })) : d("", true), e(H)([...e(g).edit]) ? (c(), i(t, { key: 2, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: h(({ row: { sourceRow: o } }) => [b(e(K), { disabledEdit: o.productType === e(s).MACHINE_PART.V, data: o, showDel: false }, null, 8, ["disabledEdit", "data"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[r, e(l).loading]]), b(e(q))]);
  };
} };
export {
  U as default
};
