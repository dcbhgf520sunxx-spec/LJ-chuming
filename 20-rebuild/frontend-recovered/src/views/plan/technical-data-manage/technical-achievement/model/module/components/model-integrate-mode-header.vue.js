import { w as B, x as D } from "../../../../../../../modules/model-0ac957f7.js";
import { B as k, E as C } from "../../../../../../../shared/runtime.js";
import { inject as c } from "vue";
import { ref as y } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as d } from "vue";
import { createBlock as f } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as v } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as E } from "vue";
import { renderSlot as N } from "vue";
import { ElNotification as h } from "element-plus";
import { ElMessageBox as T } from "element-plus";
const V = { __name: "model-integrate-mode-header", props: { info: { type: Object } }, setup(I) {
  const s = I, M = {}, { crud: a } = k(M), i = c("areaIds"), w = c("hasIntegrationModel"), u = c("hasProcessingIM"), r = y(false), l = y(false);
  async function b() {
    var t;
    try {
      if (!((t = i.value) != null && t.length)) return;
      r.value = true, await B({ areaIds: i.value, monomerId: s.info.id }), h({ title: "集成模型请求发送成功", type: "success" }), a.refresh();
    } catch (o) {
      console.log("集成模型失败", o);
    } finally {
      r.value = false;
    }
  }
  async function x() {
    T.confirm(`是否确认重置 “${s.info.name}” 单体下的集成模型`, "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        l.value = true, await D({ monomerId: s.info.id }), h({ title: "重置集成模型成功", type: "success" }), a.refresh();
      } catch (t) {
        console.log("重置集成模型失败", t);
      } finally {
        l.value = false;
      }
    });
  }
  return (t, o) => {
    const m = L("common-button"), g = j("permission");
    return d(), f(e(C), null, { optLeft: n(() => {
      var p;
      return [v((d(), f(m, { loading: r.value, type: "primary", class: "filter-item", size: "default", onClick: b, disabled: !((p = e(i)) != null && p.length) || e(u) }, { default: n(() => o[0] || (o[0] = [_("集成模型")])), _: 1, __: [0] }, 8, ["loading", "disabled"])), [[g, e(a).permission.integration]]), e(w) ? v((d(), f(m, { key: 0, type: "danger", size: "default", class: "filter-item", loading: l.value, onClick: x, disabled: e(u) }, { default: n(() => o[1] || (o[1] = [_("重置集成模型")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[g, e(a).permission.integrationDel]]) : E("", true)];
    }), viewLeft: n(() => [N(t.$slots, "viewLeft")]), _: 3 });
  };
} };
export {
  V as default
};
