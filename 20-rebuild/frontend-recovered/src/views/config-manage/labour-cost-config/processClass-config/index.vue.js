import { ref as c } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as l } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as k } from "vue";
import { ElTableColumn as v } from "element-plus";
import { vLoading as C } from "element-plus";
import { c as T } from "../../../../modules/process-class-config-a530529c.js";
import { es as D, x as L, et as s, o as R, G as B, an as E, P as I } from "../../../../shared/runtime.js";
import N from "./module/header.vue.js";
import P from "./module/form.vue.js";
const H = { class: "app-container" }, M = { class: "head-container" }, G = { __name: "index", setup(O) {
  const r = c(), m = c([["artifactType", ["parse-enum", D.ENUM]]]), { crud: o, CRUD: p } = L({ title: "构件分类", sort: [], permission: { ...s }, optShow: { add: true }, crudApi: { ...T } }, r), { maxHeight: f } = R({ paginate: true });
  return p.HOOK.handleRefresh = (_, n) => {
    n.data.content = n.data.content.map((a) => a);
  }, (_, n) => {
    const a = v, u = g("common-table"), h = C;
    return i(), y("div", H, [b("div", M, [t(e(N))]), w((i(), l(u, { ref_key: "tableRef", ref: r, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(f), style: { width: "100%" }, "data-format": m.value, "row-key": "id" }, { default: d(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { key: "classification", prop: "classification", label: "构件分类", align: "center" }), t(a, { key: "artifactType", prop: "artifactType", label: "主次构件类", align: "center" }), t(a, { key: "nameIndexList", prop: "nameIndexList", label: " 清单构件名称索引", "show-overflow-tooltip": "", align: "center" }), t(a, { key: "typeIndexList", prop: "typeIndexList", label: " 规格索引", "show-overflow-tooltip": "", align: "center" }), e(B)([...e(s).edit, ...e(s).del]) ? (i(), l(a, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: d((x) => [t(e(E), { data: x.row }, null, 8, ["data"])]), _: 1 })) : k("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[h, e(o).loading]]), t(e(I)), t(e(P))]);
  };
} };
export {
  G as default
};
